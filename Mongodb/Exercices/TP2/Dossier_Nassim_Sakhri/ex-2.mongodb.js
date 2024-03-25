use("Exos");

// 1 - Création :

// db.ex2.find();

// db.ex2.insertOne(
//     {
//     "age": 77,
//     "name": "Chuck Norris",
//     "gender": "male",
//     "email": "chucknorris@kick.com",
//     "phone": "oublie, tu pourras jamais l'appeller",
//     "address": {
//       "number": 1,
//       "street": "World Street",
//       "city": "Unknown",
//       "state": "Pennsylvany",
//       "postal": 2012
//     },
//     "favoriteFruit": "grenade",
//     "hobbies": [
//       "Karate",
//       "Kung-Fu",
//       "Ruling the world"
//     ]
//   }
// );


// 2 - lecture d'élément :

// db.ex2.find({name:"Chuck Norris"});

// db.ex2.find({name:"Chuck Norris"},{_id:0});

// db.ex2.find({$and:[{age:{$gte:20},age:{$lte:25}}]});

// db.ex2.find({$and:[{age:{$gte:30},age:{$lte:40},gender:"male"}]});

// db.ex2.find({"address.state":"Louisiana"});

// db.ex2.find().sort({age:-1}).limit(20);

// db.ex2.find({$and:[{gender:"female"},{age:30}]}).count();


// 3 - Modifier :

// db.ex2.updateMany({},{$unset:{phone:12}});

// db.ex2.updateOne({name:"Chuck Norris"},{$set:{age:"infinity"}});