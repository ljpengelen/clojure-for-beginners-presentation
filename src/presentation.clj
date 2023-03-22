(ns presentation)

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













;; A JavaScript program that computes the first 10 Fibonacci numbers

(comment
  "
   // Imperative JavaScript

   const input = [0, 1];
   const output = [];
   for (let i = 0; i < 10; ++i) {
     output.push(input[0]);
     const next = input[0] + input[1];
     input[0] = input[1];
     input[1] = next;
   }
   output;
")













;; A Clojure program that computes the first 10 Fibonacci numbers

(take 10 (map first (iterate (fn [[x y]] [y (+ x y)]) [0 1])))













;; Breaking down the expression above

(take 2 [0 1 2 3])
(map str [4 64])
(map inc [4 64])
(first [1 2 3 4])
(iterate inc 0)

(defn fib-step [[x y]]
  [y (+ x y)])

(fib-step [11 100])

;; The end result again

(take 10 (map first (iterate (fn [[x y]] [y (+ x y)]) [0 1])))

;; Evaluating the following expression prints the first 10 Fibonacci numbers, which is a side effect.
;; Generally speaking, side effects should be avoided as much as possible.
;; However, when they are needed, the language does not stand in your way.

(println (take 10 (map first (iterate (fn [[x y]] [y (+ x y)]) [0 1]))))














;; Writing and reading expression "inside out" or from right to left can be cumbersome.
;; The thread-last macro can help.
;; There's more about macro's later on.

(->> [0 1]
     (iterate (fn [[x y]] [y (+ x y)]))
     (map first)
     (take 10))

;; Because Clojure programs are expressed in terms of Clojure datastructures,
;; macro's (which transform expressions) can be implemented using plain Clojure














;; What is Clojure?
;; ================

;; Clojure is a programming language that is
;;
;; - Functional
;; - Pragmatic
;; - Dynamically typed
;; - A Lisp
;; - Equiped with persistent, immutable data structures
;; - Tailored towards applying functions from the extensive
;;   standard library on those data structures
;; - Suited for REPL-driven development
;; - Hosted on Java's JVM

;; There's also
;;
;; - ClojureScript, which compiles to JavaScript
;; - ClojureCLR, which is hosted on .Net's CLR
;; - ClojureDart, which compiles to Dart
;; - Babashka, a fast starting Clojure interpreter for scripting















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
(set [1 1 1 1 1 1 1 2])

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
(java.time.Instant/now)
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

;; Vectors are functions

([1 2] 0)

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















;; ______           _        _ _  __                                  
;; | ___ \         | |      | (_)/ _|                                 
;; | |_/ /___  __ _| |______| |_| |_ ___   _   _ ___  __ _  __ _  ___ 
;; |    // _ \/ _` | |______| | |  _/ _ \ | | | / __|/ _` |/ _` |/ _ \
;; | |\ \  __/ (_| | |      | | | ||  __/ | |_| \__ \ (_| | (_| |  __/
;; \_| \_\___|\__,_|_|      |_|_|_| \___|  \__,_|___/\__,_|\__, |\___|
;;                                                          __/ |     
;;                                                         |___/      

(require '[org.httpkit.server :as http-kit]
         '[clojure.pprint :refer [pprint]])

;; A Ring-compatible HTTP server
;; - translates HTTP requests to maps,
;; - applies a function from maps to maps to these request maps
;; - translates the resulting response map to an HTTP response

;; An HTTP request

(comment
  "
   GET /hello-world.txt HTTP/1.1
   User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)
   Host: www.example.org
   Accept-Language: en-us
   Accept-Encoding: gzip, deflate
   Connection: Keep-Alive
")

;; An HTTP response

(comment
  "
   HTTP/1.1 200 OK
   Date: Mon, 08 Mar 2022 09:50:00 GMT
   Server: Apache/2.2.14 (Win32)
   Last-Modified: Wed, 22 Jul 2021 19:10:12 GMT
   Content-Length: 123
   Content-Type: text/plain
   Connection: Closed
 
   Hello world!
")

;; As a result, Ring-based applications are implemented as functions from maps to maps

;; Plain function from maps to maps

(defn hello-world [request]
  (println "===")
  (pprint request)
  {:body "Hello World!"})

(hello-world {})

(comment
  (def stop-hello-world! (http-kit/run-server hello-world {:port 3002 :join? false}))
  (stop-hello-world!))

;; Using the request map, the hard way

(defn hello-name [{:keys [uri]}]
  {:body (str "Hello " (subs uri 1))})

(hello-name {:uri "/world"})

(comment
  (def stop-hello-name! (http-kit/run-server hello-name {:port 3002 :join? false}))
  (stop-hello-name!))

;; Using the request map with a routing library

(require '[compojure.core :refer [defroutes GET]]
         '[compojure.route :as route])

(defroutes hello-with-compojure
  (GET "/hello/:name" [name] (str "Hello " name))
  (GET "/ola/:name" [name] (str "Ola " name))
  (route/not-found "Page not found"))

(comment
  (def stop-with-compojure! (http-kit/run-server hello-with-compojure {:port 3002 :join? false}))
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
;; ============================

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
  (def stop-dwarfs-app! (http-kit/run-server dwarfs-app {:port 3002 :join? false}))
  (stop-dwarfs-app!))











;; Interacting with a database
;; ===========================

;; Sample data from https://www.w3resource.com/sql/sql-table.php

(require '[next.jdbc :as jdbc])

(def jdbc-url "jdbc:h2:mem:testdb;Mode=Oracle;DB_CLOSE_DELAY=-1")

(def ds (jdbc/get-datasource jdbc-url))

(comment
  (jdbc/execute! ds ["DROP TABLE AGENTS"])
  (jdbc/execute! ds ["CREATE TABLE AGENTS (
                      AGENT_CODE CHAR(6) NOT NULL PRIMARY KEY,
                      AGENT_NAME CHAR(40),
                      WORKING_AREA CHAR(35),
                      COMMISSION NUMBER(10,2),
                      PHONE_NO CHAR(15),
                      COUNTRY VARCHAR2(25))"]))

(comment
  (jdbc/execute-one! ds ["INSERT INTO AGENTS VALUES ('A007', 'Ramasundar', 'Bangalore', '0.15', '077-25814763', 'India')"])
  (jdbc/execute! ds ["SELECT * FROM AGENTS"])
  (jdbc/execute! ds ["SELECT * FROM AGENTS WHERE AGENT_CODE = ?" "A007"])
  (jdbc/execute! ds ["SELECT * FROM AGENTS WHERE AGENT_CODE = ?" "A006"]))

;; More user-friendly querying with HugSQL

(require '[hugsql.core :as hugsql])

;; Without the following (or something similar), the linter complains about unresolved symbols

(declare insert-agent! agent-by-code insert-agents!)

(hugsql/def-db-fns "db.sql") ;; Generates functions at compile time to execute queries

(comment
  (agent-by-code jdbc-url {:code "A007"}))

(comment
  (insert-agent! jdbc-url {:code "A003"
                           :name "Alex"
                           :working-area "London"
                           :commission "0.13"
                           :phone-number "075-12458969"
                           :country "England"}))

(comment
  (agent-by-code jdbc-url {:code "A003"}))

(comment
  (insert-agents! jdbc-url
                  {:agents
                   [["A008" "Alford" "New York" "0.12" "044-25874365" "United States"]
                    ["A011" "Ravi Kumar" "Bangalore" "0.15" "077-45625874" "India"]
                    ["A010" "Santakumar" "Chennai" "0.14" "007-22388644" "India"]
                    ["A012" "Lucida" "San Jose" "0.12" "044-52981425" "United States"]]}))

(comment
  (agent-by-code jdbc-url {:code "A012"}))

;; HugSQL is fine (great) for fixed queries

(require '[honey.sql :as sql]
         '[honey.sql.helpers :as h])

;; HoneySQL transforms maps that define queries into query strings

(def select-all-as-map {:select [:*]
                        :from [:agents]})

select-all-as-map

(def select-all-as-string
  (sql/format select-all-as-map))

select-all-as-string

(comment
  (jdbc/execute! ds select-all-as-string))

;; There are helpers for creating well-formed maps

(def get-american-agents (-> (h/select :agent_code :agent_name)
                             (h/from :agents)
                             (h/where [:= :country "United States"])
                             sql/format))

get-american-agents

(comment
  (jdbc/execute! ds get-american-agents))

;; Since maps are just data, the sky is the limit as far as query generation goes

(defn get-agents-for-country [country]
  (-> {:select [:agent_code :agent_name]
       :from :agents
       :where [:= :country country]}
      sql/format))

(get-agents-for-country "India")
















;; Combining what we've seen
;; =========================

;; We'll create an app that shows a table of all agents in the database,
;; showing only the columns that appear in the URI.

;; First, a function to extract column names from the URI

(defn uri-to-column-names [uri]
  (->> (string/split uri #"/")
       (remove string/blank?)
       (map string/upper-case)))

(uri-to-column-names "/agent_code/agent_name/country")

;; Second, a function that constructs the query for agent data

(defn agent-query [columns]
  (let [keywords (map keyword columns)]
    (-> (apply h/select keywords)
        (h/from :agents)
        sql/format)))

(agent-query ["agent_code" "country"])

;; Third, a function that retrieves data for a given collection of columns

(defn agent-data [columns]
  (jdbc/execute! ds (agent-query columns)))

(comment
  (agent-data ["agent_code" "phone-no"])
  (map :AGENTS/AGENT_CODE (agent-data [:agent_code :phone-no])))

(defn agents-app [{:keys [uri]}]
  (let [columns (uri-to-column-names uri)
        data (agent-data columns)]
    {:body (hp/html5
            [:table
             [:tr
              (for [column columns]
                [:th column])]
             (for [agent data]
               [:tr
                (for [column columns]
                  [:td ((keyword "AGENTS" column) agent)])])])}))

(comment
  (agents-app {:uri "/country/phone_no"}))

(comment
  (def stop-agents-app! (http-kit/run-server agents-app {:port 3002 :join? false}))
  (stop-agents-app!))















;; Front-end development
;; =====================

;; I've created some small example apps to illustrate
;; Reagent, a popular ClojureScript library for
;; creating SPAs:

;; https://github.com/ljpengelen/clojurescipt-rsi















;;  _____                  _           _             
;; /  __ \                | |         (_)            
;; | /  \/ ___  _ __   ___| |_   _ ___ _  ___  _ __  
;; | |    / _ \| '_ \ / __| | | | / __| |/ _ \| '_ \ 
;; | \__/\ (_) | | | | (__| | |_| \__ \ | (_) | | | |
;;  \____/\___/|_| |_|\___|_|\__,_|___/_|\___/|_| |_|

;; You've seen a lot of Clojure in a small amount of time.
;; You must be in shock.

;; If you like what you saw, I advise you to clone the
;; repository with this presentation and evaluate some
;; expressions yourself.

;; https://github.com/ljpengelen/clojure-for-beginners-presentation

;; Some good resources:

;; - https://www.braveclojure.com/
;; - https://aphyr.com/tags/Clojure-from-the-ground-up
;; - http://clojurescriptkoans.com/















;;  888888ba           dP                                                dP       oo                     
;;  88    `8b          88                                                88                              
;; a88aaaa8P' .d8888b. 88 dP    dP 88d8b.d8b. .d8888b. 88d888b. 88d888b. 88d888b. dP .d8888b. 88d8b.d8b. 
;;  88        88'  `88 88 88    88 88'`88'`88 88'  `88 88'  `88 88'  `88 88'  `88 88 Y8ooooo. 88'`88'`88 
;;  88        88.  .88 88 88.  .88 88  88  88 88.  .88 88       88.  .88 88    88 88       88 88  88  88 
;;  dP        `88888P' dP `8888P88 dP  dP  dP `88888P' dP       88Y888P' dP    dP dP `88888P' dP  dP  dP 
;;                             .88                              88                                       
;;                         d8888P                               dP                                       

;; Clojure supports polymorphic functions in various ways

;; A function is polymorphic if it can be applied to various types

(ns poly-mm) ;; We're starting a new namespace here, so we can reuse function names later on

;; The following functions return different types of
;; shapes in the form of plain maps

(defn circle [x y r]
  {:type :circle
   :x x
   :y y
   :r r})

(defn rectangle [x y w h]
  {:type :rectangle
   :x x
   :y y
   :w w
   :h h})

(defn square [x y d] (rectangle x y d d))

;; Multimethods provide one way of creating polymorphic functions

;; We'll introduce two functions, area and circumference, that can
;; be applied to the shapes created by the functions above

(defmulti area :type)

(defmulti circumference :type)

;; This will fail because we haven't provided an implementation
;; for any of the shapes yet

(area (circle 1 2 12))

(circumference (square 3 4 34))

;; We can define implementations for types of shapes as follows

(defmethod area :circle [{:keys [r]}] (* Math/PI (Math/pow r 2)))
(defmethod area :rectangle [{:keys [w h]}] (* w h))

(defmethod circumference :circle [{:keys [r]}] (* 2 Math/PI r))
(defmethod circumference :rectangle [{:keys [w h]}] (+ (* 2 w) (* 2 h)))

;; After defining the implementations, the following expressions can
;; be evaluated

(area (circle 1 2 3))
(area (rectangle 3 4 5 6))

(circumference (circle 3 4 5))
(circumference (rectangle 7 8 9 10))

;; You can extend someone else's multimethod, even when
;; you're not able to recompile the other person's code

;; Multimethods can dispatch on any value computed from
;; the input
;;
;; In the example above, we used to keyword :shape as
;; dispatch function. This could have been any function

;; Multimethods provide great extensibility, but sometimes
;; you might need something more performant. This is where
;; protocols, records, and deftype come into play

(ns poly-records) ;; New namespace, to reuse function names used above without name clashes

;; We define a protocol Shape. Each implementation of the protocol
;; must provide the functions area and circumference

(defprotocol Shape
  (area [this] "Calculate area of shape")
  (circumference [this] "Calculate circumference of shape"))

;; We define a record type Rectangle

(defrecord Rectangle [x y w h])

;; Records are map-like datatypes

(def r1 (Rectangle. 12 34 56 78))

(:x r1)

;; Adding a new value to a record produces a record

(assoc r1 :whatever "some value")

;; Removing a value from a record produces a map

(dissoc r1 :x)

;; Records cannot be used as functions

(r1 :y)

;; Records can implement protocols

(defrecord Circle [x y r]
  Shape
  (area [{:keys [r]}] (* Math/PI (Math/pow r 2)))
  (circumference [{:keys [r]}] (* 2 Math/PI r)))

(def c1 (Circle. 12 34 56))

(area c1)
(circumference c1)

;; We can extend a protocol with implementations
;; for a given record type after defining the
;; record type

(extend-protocol Shape
  Rectangle
  (area [{:keys [w h]}] (* w h))
  (circumference [{:keys [w h]}] (+ (* 2 w) (* 2 h))))

(area r1)
(circumference r1)

;; You can extend someone else's protocol, again
;; without the need to recompile the other
;; person's code

(ns poly-types)

;; Sometimes you want to introduce a new type for
;; which it doesn't make sense that all instances
;; are (also) maps. This is where deftype comes
;; into play

;; Generally speaking, records are for concepts in the
;; application domain, and types are for concepts in
;; the programming domain

(defprotocol Wrapped
  (unwrap [this] "Unwraps a wrapped object"))

(deftype Wrapper [o]
  Wrapped
  (unwrap [_] o))

(def wrapped-string (Wrapper. "wrap me"))

(unwrap wrapped-string)

;; As we've seen above, we could also use defrecord
;; to introduce a datatype that implements the
;; protocol Wrapped

(defrecord WrapperAsRecord [o]
  Wrapped
  (unwrap [_] o))

(def wrapped-string-as-record (WrapperAsRecord. "wrap me too"))

(unwrap wrapped-string-as-record)

;; One difference between the two instances created is
;; their representation when evaluated

wrapped-string
wrapped-string-as-record

;; Another difference is the default implementation
;; of equality

(= wrapped-string (Wrapper. "wrap me"))
(= wrapped-string wrapped-string)

(= wrapped-string-as-record (WrapperAsRecord. "wrap me too"))
(= wrapped-string-as-record wrapped-string-as-record)















;; .d88888b                             
;; 88.    "'                            
;; `Y88888b. 88d888b. .d8888b. .d8888b. 
;;       `8b 88'  `88 88ooood8 88'  `"" 
;; d8'   .8P 88.  .88 88.  ... 88.  ... 
;;  Y88888P  88Y888P' `88888P' `88888P' 
;;           88                         
;;           dP                         

;; Clojure is a dynamic language that doesn't offer
;; compile-time type checking

;; It does offer spec, which is a library for specifying,
;; validating and conforming the structure of your data
;; at runtime

(require '[clojure.spec.alpha :as s])

;; We'll specify the structure of simple domain events

;; First, we specify the two valid event types

(s/def :domain-events/event-type #{:password-changed :account-removed})

;; Second, we specify that user IDs are positive integers

(s/def :domain-events/user-id pos-int?)

;; Last, we specify that domain events are maps, with one
;; required unqualified (req-un) key for the type and one
;; optional unqualified (opt-un) key for the user ID

(s/def :domain-events/domain-event-map (s/keys :req-un [:domain-events/event-type]
                                               :opt-un [:domain-events/user-id]))

(def valid-password-change {:event-type :password-changed
                            :user-id 123
                            :new-password "admin"})
(def valid-account-removal {:event-type :account-removed
                            :user-id 123})
(def invalid-password-change {:event-type :password-changed
                              :user-id "admin"})
(def non-existing-event {:event-type :something-else-happened})

;; The function valid? indicates whether or not data meets
;; the given specification

(s/valid? :domain-events/domain-event-map valid-password-change)
(s/valid? :domain-events/domain-event-map valid-account-removal)
(s/valid? :domain-events/domain-event-map invalid-password-change)
(s/valid? :domain-events/domain-event-map non-existing-event)

;; The function conform returns the provided data when it meets
;; its specification and :clojure.spec.alpha/invalid otherwise

(s/conform :domain-events/domain-event-map valid-password-change)
(s/conform :domain-events/domain-event-map invalid-password-change)

;; When spec asserts are enabled, the function assert returns the
;; provided data when it meets it specification and throws an
;; exception otherwise.
;; When spec asserts are disabled, the function always returns the
;; provided data

(s/assert :domain-events/domain-event-map valid-password-change)
(s/assert :domain-events/domain-event-map invalid-password-change)

(comment
  (s/check-asserts true)
  (s/check-asserts false))

;; You can use specs to generate data, for example for use in tests

(require '[clojure.spec.gen.alpha :as gen])

(gen/generate (s/gen :domain-events/domain-event-map))
(gen/sample (s/gen :domain-events/domain-event-map))

;; Spec offers functionality to specify the structure of vectors too.
;; Suppose we want to model the domain events above as vectors

(def valid-password-change-vector [:password-changed 123 "admin"])
(def invalid-password-change-vector [:password-changed "admin" "admin"])
(def valid-account-removal-vector [:account-removed 123])
(def invalid-account-removal-vector [:account-removed])

;; The password-changed event consists of the keyword :password-changed followed
;; by a positive integer and a string

(s/def :domain-events/password-changed (s/tuple #{:password-changed} pos-int? string?))

;; The account-removed event consists of the keyword :account-removed followed by a
;; positive integer

;; The difference between tuple and cat will be apparent when conforming

(s/def :domain-events/account-removed (s/cat :event-type #{:account-removed}
                                             :user-id pos-int?))

;; A domain-event vector is either a password change or an account removal

(s/def :domain-events/domain-event-vector (s/or :password-changed :domain-events/password-changed
                                                :account-removed :domain-events/account-removed))

(s/valid? :domain-events/domain-event-vector valid-password-change-vector)
(s/valid? :domain-events/domain-event-vector invalid-password-change-vector)
(s/valid? :domain-events/domain-event-vector valid-account-removal-vector)
(s/valid? :domain-events/domain-event-vector invalid-account-removal-vector)

(s/conform :domain-events/domain-event-vector valid-password-change-vector)
(s/conform :domain-events/domain-event-vector valid-account-removal-vector)

(gen/generate (s/gen :domain-events/domain-event-vector))

;; Generally speaking, you use spec sparingly and only apply it to verify
;; the structure of complex data.

;; Many front-end projects store their global state in one place. Spec
;; comes in handy when trying to keep this data sound, for example.
