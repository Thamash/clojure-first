(ns myfirstapp.views.home
   (:require [hiccup.element :refer :all]
             [hiccup.page :as page]))


(defn home [a]
  (page/html5
   [:head
    [:title "Hello World"]
    (page/include-css "/css/bootstrap.min.css")
    (page/include-css "/css/main.css")]
   [:body
      [:div {:id "content" :class "col-sm-12"}
       [:table {:class "table table-striped"}
        [:thead
         [:tr
          [:th "ID"]
          [:th "Name"]
          [:th "Amount"]
          [:th "Type"]
          [:th "Deadline"]
          [:th "Link"]
          ]
         ]
        [:tbody
         (for [[name type amount from-company to-company from-company-address to-company-address from-company-tax to-company-tax date deadline id] a]
         [:tr
          [:td id]
          [:td name]
          [:td amount]
          [:td type]
          [:td deadline]
          [:td [:a {:href (apply str ["http://localhost:8080/" id])} "Open"]]])]]]
    ]))
