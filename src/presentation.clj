;;
;;
;;  .d8888b.  888           d8b                              .d888                    888                        d8b                                             
;; d88P  Y88b 888           Y8P                             d88P"                     888                        Y8P                                             
;; 888    888 888                                           888                       888                                                                        
;; 888        888  .d88b.  8888 888  888 888d888 .d88b.     888888 .d88b.  888d888    88888b.   .d88b.   .d88b.  888 88888b.  88888b.   .d88b.  888d888 .d8888b  
;; 888        888 d88""88b "888 888  888 888P"  d8P  Y8b    888   d88""88b 888P"      888 "88b d8P  Y8b d88P"88b 888 888 "88b 888 "88b d8P  Y8b 888P"   88K      
;; 888    888 888 888  888  888 888  888 888    88888888    888   888  888 888        888  888 88888888 888  888 888 888  888 888  888 88888888 888     "Y8888b. 
;; Y88b  d88P 888 Y88..88P  888 Y88b 888 888    Y8b.        888   Y88..88P 888        888 d88P Y8b.     Y88b 888 888 888  888 888  888 Y8b.     888          X88 
;;  "Y8888P"  888  "Y88P"   888  "Y88888 888     "Y8888     888    "Y88P"  888        88888P"   "Y8888   "Y88888 888 888  888 888  888  "Y8888  888      88888P' 
;;                          888                                                                              888                                                 
;;                         d88P                                                                         Y8b d88P                                                 
;;                       888P"                                                                           "Y88P"                                                  

;;   _                  ______                  _            
;;  | |                |  ____|                | |           
;;  | |    _   _  ___  | |__   _ __   __ _  ___| | ___ _ __  
;;  | |   | | | |/ __| |  __| | '_ \ / _` |/ _ \ |/ _ \ '_ \ 
;;  | |___| |_| | (__  | |____| | | | (_| |  __/ |  __/ | | |
;;  |______\__,_|\___| |______|_| |_|\__, |\___|_|\___|_| |_|
;;                                    __/ |                  
;;                                   |___/                   

;; https://textkool.com/en















;; What is Clojure?
;; ================

;; Clojure is a programming language that is
;;
;; - Functional
;; - Pragmatic
;; - ...















(comment
  "
   // Imperative JavaScript

   const input = [1, 2, 3, 4];
   const output = [];
   for (let i = 0; i < input.length; ++i) {
     const current = input[i];
     if (current % 2 == 0) {
       output.push(current * current);
     }
   }
   output;
")

(map (fn [x] (* x x)) (filter even? [1 2 3 4]))















(even? 10)
(even? 11)
(filter even? [1 2 3 4])
(filter odd? [1 2 3 4])
(map str [4 64])
(map inc [4 64])

(map (fn [x] (* x x)) (filter even? [1 2 3 4]))















;; What is Clojure?
;; ================

;; Clojure is a programming language that is
;;
;; - Pragmatic
;; - Functional
;; - Dynamically typed
;; - A Lisp
;; - Equiped with persistent, immutable data structures
;; - Tailered towards applying functions from the extensive
;;   standard library on those data structures
;; - Suited for REPL-driven development
;; - Hosted on Java's JVM

;; There's also
;;
;; - ClojureScript, which compiles to JavaScript
;; - ClojureCLR, which is hosted on .Net's CLR















;; ______      _        
;; |  _  \    | |       
;; | | | |__ _| |_ __ _ 
;; | | | / _` | __/ _` |
;; | |/ / (_| | || (_| |
;; |___/ \__,_|\__\__,_|

;; Numbers

1
2
3
3.0
1/3
2139823749827349237492374219831289731278321987312793984723987423972339823978432789234987423978243798234978243798478234983427923479
3982374923823948732984774.2398764239874789324789324789234789234789423798234789723449827394387298237492374329874982374
3982374923823948732984774.2398764239874789324789324789234789234789423798234789723449827394387298237492374329874982374M

;; Strings

"abcde"

"string
 containing
 newline characters."

;; Boolean constants

true
false

;; Value representing nothing

nil

;; Characters

\a
\b
\'

;; Keywords

:keyword
:other-keyword
:nl.cofx.cfb/keyword

;; Vectors

[1 2 3]
[1, 2, 3]
[1 "string" \a [1 2 3 nil]]
[:password-changed 123 "admin"]

;; Maps

{2 "Two"
 3 "Three"}

{:two 2
 :three 3}

{:username "admin"
 :password "admin"
 :account-id 123
 :occupation :software-developer
 :blog-posts [54, 123]}

;; Sets

#{1 2 3 4 5}
#{"abc" "def"}

;; Lists

()
'(1 2 3)
















;; ______                _   _                 
;; |  ___|              | | (_)                
;; | |_ _   _ _ __   ___| |_ _  ___  _ __  ___ 
;; |  _| | | | '_ \ / __| __| |/ _ \| '_ \/ __|
;; | | | |_| | | | | (__| |_| | (_) | | | \__ \
;; \_|  \__,_|_| |_|\___|\__|_|\___/|_| |_|___/

;; Using functions

(even? 10)
(+ 6 6)
(max 1 2 3 4 5)
(true? false)
(true? nil)
(Math/sqrt 9)
(reverse "abcde")

(require '[clojure.string :as string])
(string/reverse "abcde")

;; Maps are functions

({2 "Two"
  3 "Three"} 2)

({:two "Two"
  :three "Three"} :two)

;; Keywords are functions

(:two {:two "Two"})

;; Defining a function

(defn sqr [x] (* x x))

(sqr 6)

(map sqr [1 2 3 4])

;; Using an anonymous function, because naming things is hard

(map (fn [x] (* x x)) [5 6 7 8])

;; Using a function literal, because naming function parameters is also hard

(map #(* % %) [10 11 12 13])

;; There are many functions available in the standard library

(comment
  (repeat 10 1)
  (rand-int 10)
  (repeatedly 10 #(rand-int 10))
  (range 99)
  (take 8 (range 99))
  (take 8 (range))
  (first [1 2 3 4])
  (last [1 2 3 4])
  (take 10 (cycle [1 2]))
  (take 10 (iterate inc 9))
  (partition 3 2 (range 10))

  (filter odd? [5 6 7 8 9 10])
  (remove odd? [5 6 7 8 9 10])

  ;; Functions to create functions

  (constantly 10)
  ((constantly 10))

  (complement odd?)
  ((complement odd?) 2)

  ;; Nice-to-have default functions

  (map identity [6 7 8])
  
  ;; Functions to create new maps from existing maps
  
  (assoc {:one 1} :two 2)
  (dissoc {:one 1 :two 2} :one)
  (merge {:one 1} {:two 2})
  
  ;; Functions to create new collections from existing collections

  (conj [1 2 3] 4)
  (conj '(1 2 3) 4)
  (concat [1 2 3] [4 5 6])
  (concat '(1 2 3) '(4 5 6))

  ;; Functions you didn't know you needed

  (frequencies [1 2 3 3 1 2 3 3 1 3 3 2 1 2 3 3 2 1 1])
  (interpose 42 (range 9)))















;; Try this at home
;; ================

;; Visit https://cfb.cofx.nl/ and try the first few exercises.
;; 
;; Stop when you see '->>'.















;; ___  ___                         
;; |  \/  |                         
;; | .  . | __ _  ___ _ __ ___  ___ 
;; | |\/| |/ _` |/ __| '__/ _ \/ __|
;; | |  | | (_| | (__| | | (_) \__ \
;; \_|  |_/\__,_|\___|_|  \___/|___/

;; Composing functions can get cumbersome

(apply + (filter #(> % 5) (filter even? [1 2 3 4 5 6 7 8 9 10])))

;; The thread-last macro improves readability

(->> [1 2 3 4 5 6 7 8 9 10]
     (filter even?)
     (filter #(> % 5))
     (apply +))

(macroexpand '(->> [1 2 3 4 5 6 7 8 9 10]
                   (filter even?)
                   (filter #(> % 5))
                   (apply +)))

(macroexpand '(->> x
                   (f 1)
                   (g 2 3)
                   h))

;; There's also a thread-first macro

(-> (java.time.LocalDate/now)
    (.plusDays 1)
    (.plusWeeks 1)
    str)

;; You can create your own macros

(defmacro rev [& x]
  (println x)
  (reverse x))

(rev 1 2 3 +)

(macroexpand '(rev 2 3 *))

(repeatedly 10 #(rev 1 2 +))

;; One use case: avoiding expensive evaluation of arguments

(defn unless-as-fn [test then else]
  (if (not test) then else))

(defn expensive-fn []
  (Thread/sleep 2000)
  "expensive")

(defn cheap-fn [] "cheap")

(unless-as-fn false (cheap-fn) (expensive-fn)) ;; Takes two seconds

(defmacro unless-as-macro [test then else]
  `(if (not ~test) ~then ~else))

;; You could compare the above with template literals in JavaScript:
;; `The value of variable x is ${x}`

(unless-as-macro false (cheap-fn) (expensive-fn)) ;; Returns immediately

(macroexpand '(unless-as-macro false (cheap-fn) (expensive-fn)))

;; See https://purelyfunctional.tv/mini-guide/when-to-use-a-macro-in-clojure/ for other use cases















;; Try this at home
;; ================

;; Visit https://cfb.cofx.nl/ and try the next three exercises.















;;  _____                  _           _     ___  _ ___  
;; /  ___|                | |         | |   |__ \| |__ \ 
;; \ `--.  ___   __      _| |__   __ _| |_     ) | |  ) |
;;  `--. \/ _ \  \ \ /\ / / '_ \ / _` | __|   / /| | / / 
;; /\__/ / (_) |  \ V  V /| | | | (_| | |_   |_| |_||_|  
;; \____/ \___/    \_/\_/ |_| |_|\__,_|\__|  (_) (_)(_)  

;; Immutable, persistent data structures

(def short-list [1 2 3])
(def longer-list (conj short-list 4 5 6))

short-list ;; Unmodified
longer-list ;; Reuses short-list under the hood

(def complex-map
  {:name "Luc"
   :presentations [{:name "Clojure for beginners"
                    :venue "DevConf 2022"}]})

(def modified-map (-> complex-map
                      (update :name #(str % " Engelen"))
                      (assoc :age 40)
                      (assoc-in [:presentations 0 :year] 2022)))

complex-map ;; Unmodified
modified-map ;; Reuses complex-map under the hood

;; Pure functions and immutable data structures have attractive properties that are useful in any language
;; - Easy to reason about
;; - Easy to test

;; Functions with side effects can lead to unpleasant surprises

(comment
  "
   const x = [65, 12, 0];
   const smallest = a => a.sort()[0];
   smallest(x);
   x
")

;; Copy before modify is cumbersome as well as potentially expensive and dangerous

(comment
  "
   const smallest = a => {
     const b = [...a];
     return b.sort()[0];
   }
")

;; Persistent data structures lead to more efficient implementations of pure functions

;; Clojure libraries mostly revolve around these simple data structures combined with custom functions and a few macros

;; Sticking to these data structures 
;; - allows use of the rich standard library
;; - elimates the need to introduce boilerplate classes















;;   ___        _                 _                     _                         
;;  / _ \      (_)               | |                   | |                        
;; / /_\ \  ___ _ _ __ ___  _ __ | | ___  __      _____| |__     __ _ _ __  _ __  
;; |  _  | / __| | '_ ` _ \| '_ \| |/ _ \ \ \ /\ / / _ \ '_ \   / _` | '_ \| '_ \ 
;; | | | | \__ \ | | | | | | |_) | |  __/  \ V  V /  __/ |_) | | (_| | |_) | |_) |
;; \_| |_/ |___/_|_| |_| |_| .__/|_|\___|   \_/\_/ \___|_.__/   \__,_| .__/| .__/ 
;;                         | |                                       | |   | |    
;;                         |_|                                       |_|   |_|    

(require '[org.httpkit.server :as http-kit]
         '[clojure.pprint :refer [pprint]])

;; Plain function from map to map

(defn hello-world [request]
  (println "===")
  (pprint request)
  {:body "Hello World!"})

(hello-world {})

(comment
  (def stop-hello-world! (http-kit/run-server hello-world {:port 3000 :join? false}))
  (stop-hello-world!))

;; Using the request map, the hard way

(defn hello-name [{:keys [uri]}]
  {:body (str "Hello " (subs uri 1))})

(hello-name {:uri "/world"})

(comment
  (def stop-hello-name! (http-kit/run-server hello-name {:port 3000 :join? false}))
  (stop-hello-name!))

;; Using the request map with a routing library

(require '[compojure.core :refer [defroutes GET]]
         '[compojure.route :as route])

(defroutes hello-with-compojure
  (GET "/hello/:name" [name] (str "Hello " name))
  (GET "/ola/:name" [name] (str "Ola " name))
  (route/not-found "Page not found"))

(comment
  (def stop-with-compojure! (http-kit/run-server hello-with-compojure {:port 3000 :join? false}))
  (stop-with-compojure!))

;; Examining a route

(def get-route (GET "/test" [] "Test"))

(get-route {})
(get-route {:uri "/test"})
(get-route {:uri "/test"
    :request-method :get})

;; Easy to test

(=
 (get-route {:uri "/test" :request-method :get})
 {:status 200, :headers {"Content-Type" "text/html; charset=utf-8"}, :body "Test"})















;; Generating HTML from vectors

(require '[hiccup.core :as hc]
         '[hiccup.page :as hp])

(hc/html [:html
          [:body
           [:p
            [:b "This is a paragraph in bold."]
            [:a {:href "https://www.nu.nl/"} "This is a link."]]]])

(def dwarfs ["Doc" "Dopey" "Bashful" "Grumpy" "Sneezy" "Sleepy" "Happy"])

(defn to-html-list [items]
  [:ul (for [item items] [:li item])])

(to-html-list dwarfs)

;; Also easy to test
(=
 (to-html-list ["Aap" "Noot" "Mies"])
 [:ul [[:li "Aap"] [:li "Noot"] [:li "Mies"]]])

;; Easy to apply in larger context

(defn dwarfs-app [_]
  {:body (hp/html5
          [:h1 "The seven dwarfs"]
          [:div (to-html-list dwarfs)]
          [:a {:href "https://en.wikipedia.org/wiki/Seven_Dwarfs"} "More about these dwarfs"])})

(comment
  (def stop-dwarfs-app! (http-kit/run-server dwarfs-app {:port 3000 :join? false}))
  (stop-dwarfs-app!))
