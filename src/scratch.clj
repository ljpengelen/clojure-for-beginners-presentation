(ns scratch)

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
