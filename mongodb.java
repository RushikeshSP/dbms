package com.mongodb;

import com.mongodb.*;

public class DBMS {

	public static void main(String[] args) {
		try {
			
			MongoClient mongo = new MongoClient("localhost", 27017);
			
			DB db = mongo.getDB("Student");
			
			DBCollection coll = db.getCollection("lab");
			
			// Insert
			BasicDBObject obj1 = new BasicDBObject();
			obj1.put("lname", "newLab");
			obj1.put("div", "A");
			coll.insert(obj1);
			
			BasicDBObject obj2 = new BasicDBObject();
			obj2.put("lname", "newLab2");
			obj2.put("div", "B");
			obj2.put("class", "BE");
			coll.insert(obj2);
			
			//Display Document before Updating
			System.out.println("After Updating Document: ");
			DBCursor cursor = coll.find();
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			// Update
			BasicDBObject oldDoc = new BasicDBObject("name", "Rushi");
			BasicDBObject newDoc = new BasicDBObject("name", "Adi");
			BasicDBObject updateDoc = new BasicDBObject("$set", newDoc);
			coll.update(oldDoc, updateDoc);
			
			// remove
			coll.remove(obj2);			
			
			//Display Document after Updating
			System.out.println("After Updating Document: ");
			DBCursor cursor1 = coll.find();
			while(cursor1.hasNext()) {
				System.out.println(cursor1.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
