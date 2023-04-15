(ns scratch 
  (:require [clojure.data.xml :as xml]))

(defn is-sorted? [coll]
  (->> coll
       (partition 2 1)
       (every? (fn [[x y]] (<= x y)))))

(shuffle [3 2 1])

(defn bogosort [coll]
  (->> (repeatedly #(shuffle coll))
       (filter is-sorted?)
       first))

(bogosort [87 1 45 3 4 44 3939])

(defn xml-tags-to-string [tags]
  (let [string-writer (java.io.StringWriter.)]
    (-> tags
         xml/sexp-as-element
         (xml/emit string-writer)
        .toString)))

(xml-tags-to-string [:elems [:elem {:attr "val"}]])
