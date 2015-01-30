# pg-playground

Experiments with PostgreSQL 9.4+ features, such as json/jsonb/hstore (via Clojure, i.e. JDBC).


## Usage

Install PostgreSQL 9.4+, create local user and database, explore.

    sudo -u postgres createuser playground
    sudo -u postgres createdb -O playground playground

See:

* http://www.postgresql.org/docs/9.4/static/datatype-json.html
* http://www.postgresql.org/docs/9.4/static/functions-json.html

Note: The jsonb type is not yet supported by clj-postgresql, see:

* https://github.com/remodoy/clj-postgresql/pull/3

TODO: Come back here once jsonb is included.


## License

Copyright © 2015 Daniel J. Hofmann

Distributed under the MIT License (MIT).
