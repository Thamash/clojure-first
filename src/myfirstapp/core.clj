(ns myfirstapp.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]
            [myfirstapp.views.home :as vh]
            [myfirstapp.views.element :as ve]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [datascript.core :as d]))

(def db-data
  [{:db/id -1
    :name "Salary Jan"
    :type "IN"
    :amount "900000"
    :from-company "Company A"
    :to-company "Company-B"
    :from-company-address "25. Andrássy street, Budapest, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-12"
    :deadline "2020-05-27"
    :id 1}
   {:db/id -2
    :name "Salary Jan"
    :type "OUT"
    :amount "100000"
    :from-company "Company C"
    :to-company "Company-B"
    :from-company-address "1. Kinizsi street, Békéscsaba, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-21"
    :deadline "2020-06-8"
    :id 2}
   {:db/id -1
    :name "Salary Jan"
    :type "IN"
    :amount "900000"
    :from-company "Company A"
    :to-company "Company-B"
    :from-company-address "25. Andrássy street, Budapest, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-12"
    :deadline "2020-05-27"
    :id 1}
   {:db/id -3
    :name "Salary Jan"
    :type "IN"
    :amount "100000"
    :from-company "Company C"
    :to-company "Company-B"
    :from-company-address "1. Kinizsi street, Békéscsaba, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-21"
    :deadline "2020-06-8"
    :id 3}
   {:db/id -4
    :name "Salary Jan"
    :type "IN"
    :amount "900000"
    :from-company "Company A"
    :to-company "Company-B"
    :from-company-address "25. Andrássy street, Budapest, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-12"
    :deadline "2020-05-27"
    :id 4}
   {:db/id -5
    :name "Salary Jan"
    :type "IN"
    :amount "100000"
    :from-company "Company C"
    :to-company "Company-B"
    :from-company-address "1. Kinizsi street, Békéscsaba, Hungary"
    :to-company-address "83. Váci street, Budapest, Hungary"
    :from-company-tax "1235468-7-21"
    :to-company-tax "98542187-7-21"
    :date "2020-05-21"
    :deadline "2020-06-8"
    :id 5}])

(def get-all-where
  '[:find  ?name ?type ?amount ?from-company ?to-company ?from-company-address ?to-company-address ?from-company-tax ?to-company-tax ?date ?deadline ?id
    :where [(not= :id 0)]
    [?e :name ?name]
    [?e :type  ?type]
    [?e :amount  ?amount]
    [?e :from-company  ?from-company]
    [?e :to-company  ?to-company]
    [?e :from-company-address  ?from-company-address]
    [?e :to-company-address  ?to-company-address]
    [?e :from-company-tax  ?from-company-tax]
    [?e :to-company-tax  ?to-company-tax]
    [?e :date  ?date]
    [?e :deadline  ?deadline]
    [?e :id ?id]])




(defn get-one-where [uid]
  '[:find  ?name ?type ?amount ?from-company ?to-company ?from-company-address ?to-company-address ?from-company-tax ?to-company-tax ?date ?deadline ?id
    ;:where [?e :id uid]
    :where [?e :id 2]
    [?e :name ?name]
    [?e :type  ?type]
    [?e :amount  ?amount]
    [?e :from-company  ?from-company]
    [?e :to-company  ?to-company]
    [?e :from-company-address  ?from-company-address]
    [?e :to-company-address  ?to-company-address]
    [?e :from-company-tax  ?from-company-tax]
    [?e :to-company-tax  ?to-company-tax]
    [?e :date  ?date]
    [?e :deadline  ?deadline]
    [?e :id ?id]])

(defn db
  [data where]
  (let [conn   (d/create-conn)]
    (d/transact! conn data)
    (d/q where
         @conn)))

(defroutes routes
  (GET "/" [] (vh/home (db db-data get-all-where)))
  (GET "/:id" [id :as req] (ve/home (db db-data (get-one-where id))))
  (route/resources "/")
  )

(def app (wrap-defaults routes site-defaults))


(defn start [port]
  (ring/run-jetty app {:port port
                               :join? false}))
(defn -main []
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))
