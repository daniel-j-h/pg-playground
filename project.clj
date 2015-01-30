(defproject pg-playground "0.0.1"
  :description "Playground for PostgreSQL 9.4+ features"
  :url "https://github.com/daniel-j-h/pg-playground"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [org.clojure/data.json "0.2.5"]
                 [clj-postgresql "0.4.0"]]
  :global-vars {*warn-on-reflection* false
                *read-eval* false
                *assert* true}
  :jvm-opts ["-Xmx1g" "-server"]
  :javac-options ["-source" "1.7" "-target" "1.7"]
  :profiles {:uberjar {:aot :all}}
  :main pg-playground.core)
