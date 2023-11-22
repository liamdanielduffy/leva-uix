(ns app.app
  (:require
   [uix.core :as uix :refer [defui $ defhook]]
   [uix.dom]
   [leva.core :as leva]))

(defonce my-atom (atom {:height "100px"}))

;; given some initial state
;; - define an atom with that initial state
;; - useEffect to watch that atom and update the state
;; - react to changes in the state by updating the atom
;; - returns current state, set state, atom

;; useLevaAtom
;; store the atom as state
;; - return atom


(defhook use-reactive-atom [!atom]
  (let [[flag set-flag!] (uix/use-state false)
        [watch-id] (uix/use-state (str (random-uuid)))]

    (uix/use-effect
     (fn []
       (js/console.log "watching atom")
       (when !atom

         (let [watch-fn #(set-flag! (not flag))
               cleanup-fn #(remove-watch !atom watch-id)]

           (add-watch !atom watch-id watch-fn)

           #(cleanup-fn)))))
    [watch-id !atom]))


(defui leva-demo []
  (use-reactive-atom my-atom)
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
