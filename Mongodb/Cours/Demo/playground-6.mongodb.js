use("restau")

// Récupère tous les restaurants
//db.restaurant.find();

// Récupère les restaurants avec une note > 5
//db.restaurant.aggregate({$match: {rating: 5}})

// Récupère les restaurants avec une note > 5 et affiche le nombre de restau
//db.restaurant.aggregate({$match: {rating: 5}}, {$count:"comptage"})

// Récupère les restaurants avec une note > 5 et affiche l'URL et le nom ?
//db.restaurant.aggregate({$match: {rating: 5}}, {$project:{URL:1, name:1}})

// Regroupe les restau par type de restau et donne leur nombre.
//db.restaurant.aggregate({$group: {_id: "$type_of_food", count: {$sum:1}}})

// Regroupe les restau par type de restau, donne leur nombre et puis ne garde que les types avec plus de 10 restau
//db.restaurant.aggregate([{$group: {_id: "$type_of_food", count: {$sum:1}}},{$match:{count:{$gt:10}}}])

// Regroupe les restau par type de restau, donne leur nombre, puis ne garde que les types avec plus de 10 restau et les tri de manière décroissante (en se bsant sur count)
/* db.restaurant.aggregate([
  { $group: { _id: "$type_of_food", count: { $sum: 1 } } },
  { $match: { count: { $gt: 10 } } },
  { $sort: { count: -1 } }]) */

// Regroupe par codepostal et affiche le nombre de restau par code postal
//db.restaurant.aggregate({$group: {_id: "$postcode", nombre_restaurant : {$sum:1}}});

// Affiche les restau de type Thai avec une note supérieur à 4
//db.restaurant.aggregate({$match : {type_of_food: "Thai", rating:{$gt: 4}}})

// Affiche les restau de type Thai avec une note supérieur à 4, puis affiche que le type, la note uniquement les 3 premiers résultats.
//db.restaurant.aggregate([{$match : {type_of_food: "Thai", rating:{$gt: 4}}},{$project: {_id: 0, type_of_food:1, rating: 1}},{$limit: 3}])

// Me donne les nombre de restau Caribbean
//db.restaurant.aggregate({$match : {type_of_food: "Caribbean"}}, {$count: "no_restau_caribbean"})

// Me donne la note moyenne pour chaque typologie de restau
//db.restaurant.aggregate({$group: {_id: "$type_of_food", note_moyenne : {$avg: "$rating"}}})
/* 

// Me donne par typo de restau, la somme des notes, leurs moyennes, la note min et max
db.restaurant.aggregate([
  {$match: {rating: {$ne : "Not yet rated"}}},
  {$group : {_id: "$type_of_food", total_rating : {$sum : "$rating"}, 
  avg_rating : {$avg: "$rating"}, 
  max_rating : {$max: "$rating"}, 
  min_rating : {$min: "$rating"} }}])
 */