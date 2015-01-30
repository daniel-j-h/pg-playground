(ns pg-playground.db
  (:require [clj-postgresql.core :as pg]))



(def db (pg/spec :dbname   "playground"
                 :user     "playground"
                 :password "playground"))

