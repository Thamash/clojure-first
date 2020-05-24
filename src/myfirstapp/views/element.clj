(ns myfirstapp.views.element
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
     [:div {:class "col-sm-12 text-left"}
      [:a {:href "http://localhost:8080"} "Back"]]
     [:div {:class "col-sm-10 col-offset-1"}

       (for [[name type amount from-company to-company from-company-address to-company-address from-company-tax to-company-tax date deadline id] a]
         [:form {:id "billForm" :class "form-horizontal"}
          [:div {:class "form-group"}
           [:label {:class "control-label col-sm-2 text-left"} "ID: "]
           [:div {:class "col-sm-10"}
            [:p {:class "form-control-static"} id]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "Name: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} name]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "Type: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} type]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "Amount: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} amount]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "From Company: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} from-company]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "To Company: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} to-company]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "From Comapny Address: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} from-company-address]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "To Company Address: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} to-company-address]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "From Company Tax Number: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} from-company-tax]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "To Company Tax Number: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} to-company-tax]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "Date: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} date]]]
         [:div {:class "form-group"}
          [:label {:class "control-label col-sm-2 text-left"} "Deadline: "]
          [:div {:class "col-sm-10"}
           [:p {:class "form-control-static"} deadline]]]


         ])
       ]]]))



