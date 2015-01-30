(ns pg-playground.json
  (:require [pg-playground.db :refer [db]]
            [clojure.java.jdbc :as jdbc]
            [clojure.data.json :as json]
            [clj-postgresql.core :as pg]))



(defn drop-table [table]
  (jdbc/db-do-commands db
                       (jdbc/drop-table-ddl table)))

(defn create-table [table]
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl table
                                              [:id  "serial primary key"]
                                              [:doc "json not null"])))

(defn clean-table [table]
  ((juxt drop-table create-table) table))


(defn docs->table [table docs]
  (jdbc/with-db-connection [con db]
    (doseq [doc docs]
      (jdbc/insert! con table {:doc doc}))))
