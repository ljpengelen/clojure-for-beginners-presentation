(ns xml 
  (:require [clojure.data.xml :as xml]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]))

(def parsed-xml (xml/parse (io/reader "src/books.xml")))

(->> parsed-xml
     :content
     (map :content)
     (map (fn [book-elements] (first (filter (fn [{:keys [tag]}] (= tag :price)) book-elements))))
     (map :content)
     (map first)
     (map parse-double)
     (reduce + 0))

(s/def :xml-books-price/content (s/coll-of parse-double :count 1))
(s/valid? :xml-books-price/content ["13.5"])
(s/valid? :xml-books-price/content ["a5"])
(s/def :xml-books-price/tag #{:price})

(s/def :xml-books/price (s/keys :req-un [:xml-books-price/tag :xml-books-price/content]))
(s/valid? :xml-books/price {:tag :price
                                  :content ["13.5"]})

(s/def :xml-books-book/content (s/coll-of (s/or :price :xml-books/price :other any?)))
(s/def :xml-books-book/tag #{:book})
(s/def :xml-books/book (s/keys :req-un [:xml-books-book/tag :xml-books-book/content]))
(s/valid? :xml-books/book {:tag :book
                                :content [{:tag :price
                                           :content ["13.5"]}
                                          {:tag :author}]})

(s/def :xml-books-catalog/content (s/coll-of :xml-books/book))
(s/def :xml-books-catalog/tag #{:catalog})
(s/def :xml-books/catalog (s/keys :req-un [:xml-books-catalog/tag :xml-books-catalog/content]))

(s/valid? :xml-books/catalog (xml/parse (io/reader "src/books.xml")))
(s/explain :xml-books/catalog (xml/parse (io/reader "src/books.xml")))