(defproject myfirstapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.2.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.4"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [datascript "0.18.13"]]
  :repl-options {:init-ns myfirstapp.core})
