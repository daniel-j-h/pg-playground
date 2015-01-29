(ns pg-playground.core
  (:require [clojure.java.jdbc :as sql]
            [clojure.data.json :as json]
            [environ.core :refer [env]])
  (:import [org.postgresql.util PGobject]))


(def db-spec {:subprotocol "postgresql"
              :subname     "//localhost/playground"
              :user        (or (env :pg_user)     "playground")
              :password    (or (env :pg_password) "playground")})


(defn drop-table [table]
  (sql/db-do-commands db-spec
                      (sql/drop-table-ddl table)))

(defn create-table [table]
  (sql/db-do-commands db-spec
                      (sql/create-table-ddl table
                                            [:id  "serial primary key"]
                                            [:doc "json not null"])))

(defn clean-table [table]
  ((juxt drop-table create-table) table))


;; using jdbc we have to be explicit
(defn json->pgjson [text]
  (doto (PGobject.)
    (.setType "json")
    (.setValue text)))


(defn docs->table [table docs]
  (sql/with-db-connection [db-con db-spec]
    (doseq [doc docs]
      (->> doc
           (json/write-str)
           (json->pgjson)
           (assoc {} :doc)
           (sql/insert! db-con table)))))

;; (docs->table :playground [{:x 1 :y 2 :z {"hello" 1}}])


(defn -main [& args]
  (println "explore via repl"))
