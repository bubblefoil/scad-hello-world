(ns scad-btn.base-plate
  (:require [scad-clj.scad :as s]
            [scad-clj.model :as m]
            [scad-clj.geometry :as g]
            [bubblefoil.scad.toolbox :refer [drill mirrored-h mirrored-v] :as t]
            [bubblefoil.scad.color :as col]))

;    Y ^
;      |
;  +--------
;  |*  |  *|
;  |   |   |
;  |   |   |
;------+-------->
;  |   |   |    X
;  |   |   |
;  |*  |  *|
;  +--------
;      |
;      |

(comment
  (hsv 25 80 50)
  (hsv 25 80 50 30))

(def plate-size-x 82)
(def plate-size-y 110)
(def screw-hole-dist-x 71.5)
(def screw-hole-dist-y 52.5)

(def dc-dc-size-x 60.2)
(def dc-dc-size-y 43)

(defn half [n] (/ n 2))

(defn red [m] (m/color (col/html :red) m))

(def latch-screw-hole
  (m/hull
    (m/translate [3 2] (t/smooth-circle 1.5))
    (m/translate [3 3] (t/smooth-circle 1.5))
    (m/translate [10.5 2] (t/smooth-circle 1.5))))

(def latch
  (m/difference
    (m/minkowski
      (m/square 12 3.5 :center false)
      (t/smooth-circle 1.5))
    latch-screw-hole))

(def latches
  (->> latch
       (m/translate [(- (half dc-dc-size-x))
                     (- (half dc-dc-size-y))])
       mirrored-h
       mirrored-v))

(def dc-dc-cut-out
  (->> (m/difference
         (m/square dc-dc-size-x dc-dc-size-y)
         latches)
       (m/translate [0
                     (- (half plate-size-y) (half dc-dc-size-y) 2)])))

(def quarter-plate
  (m/square (half plate-size-x)
            (half plate-size-y)
            :center false))

(def plate
  (->> quarter-plate
       (drill 3 (half screw-hole-dist-x) (half screw-hole-dist-y))
       mirrored-h
       mirrored-v
       (m/color (col/hsv 180 10 50 75))))

(def base-plate (m/difference plate
                              dc-dc-cut-out))

(comment
  (def base-plate
    (m/union (m/color (col/hsv 50 50 50 75) latch)
             (m/color (col/hsv 10 50 50 75) latch-screw-hole))))

(defn kill-z-fight
  "Extrudes and projects the model."
  [m]
  (m/projection true (m/extrude-linear {:height 20} m)))

(spit "test.scad" (->> base-plate
                       ;kill-z-fight
                       s/write-scad))