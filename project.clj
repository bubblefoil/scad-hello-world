(defproject scad-btn "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [scad-clj "0.5.3"]
                 [com.evocomputing/colors "1.0.6"]]
  :main ^:skip-aot scad-btn.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
