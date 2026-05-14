# v0 Orbit Feature API Contract

## Base Endpoint

/api/v1

## Yapper

### Object

```
	{
		uuid: integer
		yapperId: string
		name: string
		email: string
		dob: datetime(iso 8601)
		spawnedOn: datetime(iso 8601)
	}
```
### Endpoint
/yappers

### Methods

**GET /yappers**
----
Returns all yappers in Ohio.

* **URL Params**  
None

* **Data Params**  
None

* **Headers**  
Content-Type: application/json

* **Success Response:**  
**Code:** 200  
**Content:**  
```
	{
		yappers: [
					{<yapper_object>},
					{<yapper_object>},
					{<yapper_object>},
	        ]
	}
```

**GET /yappers/:id**
----
Returns the one and only MC yapper

* **URL Params**
None

* **Data Params**
None

* **Headers**
Content-Type: application/json

* **Success Response:**  
**Code:** 200  
**Content:**  
`{ <yapper_object> }`

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`

**POST /yappers**
----
Spawns a dope Yapper and returns them to ya.

* **URL Params**  
None

* **Headers**  
Content-Type: application/json  

* **Data Params**  
```
	{
		yapperId: string,
		name: string,
		email: string,
		dob: datetime(iso 8601)
	}
```

* **Success Response:**  
**Code:** 201  
**Content:**  
`{ <yapper_object> }` 

## Orbiter

### Object
```
	{
	    orbiterId: integer
	    orbiteeId: integer
	}
```

### Endpoint
/orbiters

### Methods

**POST /orbiters**
----
Orbit another one

* **URL Params**
None

* **Headers**
Content-Type: application/json

* **Data Params**
```
	{
		orbiterId: integer
		orbiteeId: integer
	}
```
* **Success Response:**  
**Code:** 201  
**Content:**  
`{ <orbiter_object> }`

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`