(ns app.app
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   [leva.core :as leva]))

(defonce my-atom (atom {:height "100px"}))

(defui leva-demo []
  ($ :<>
     (:height @my-atom)
     ($ leva/SubPanel {:opts {:titleBar {:drag true}}} ($ leva/Controls {:opts {:atom my-atom}}))))

(defui leva-app []
  ($ :<> ($ leva-demo)))

(defonce root
  (uix.dom/create-root (js/document.getElementById "root")))

(defn mount-root []
  (uix.dom/render-root ($ leva-app) root))

;; (defonce root
;;   (uix.dom/create-root (js/document.getElementById "root")))

;; (uix.dom/render-root ($ app) root)

(defn ^:export init! []
  (mount-root))
