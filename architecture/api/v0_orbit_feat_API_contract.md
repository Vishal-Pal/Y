# v0 Orbit Feature API Contract

## Base Endpoint

/api/v1

## Yapper

### Object

```
	{
		yapperId: string
		name: string
		email: string
		dob: datetime(iso 8601)
	}
```
### Endpoint
/yappers

### Methods

#### GET /yappers
----
Returns all yappers in Ohio.

* **URL Params**  
None

* **Data Params**  
None

* **Success Response:**  
**Code:** 200  
**Content:**  
```
	[
		{<yapper_object>},
		{<yapper_object>},
		{<yapper_object>}
	]
```

#### GET /yappers/:id
----
Returns the one and only MC yapper

* **URL Params**  
Required: id=[string]

* **Data Params**  
None

* **Success Response:**  
**Code:** 200  
**Content:**  
`{ <yapper_object> }`

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`

#### POST /yappers
----
Spawns a dope Yapper and returns them to ya.

* **URL Params**  
None

* **Data Params**  
```
	{<yapper_object>}
```

* **Headers**  
Content-Type: application/json  

* **Success Response:**  
**Code:** 201  
**Content:**  
`{ <yapper_object> }` 

## Orbiter

### Object
None

### Endpoint
/yappers/:orbiteeId/orbiters/

### Methods  

#### GET /yappers/:orbiteeId/orbiters/
----
Returns all the orbiters of the OG yapper

* **URL Params**  
Required: orbiteeId=[string]

* **Data Params**  
None

* **Success Response:**  
**Code:** 200  
**Content:**  
```
	[
		{<yapper_object>},
		{<yapper_object>},
		{<yapper_object>}
	]
```

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`

#### POST /yappers/:orbiteeId/orbiters/
----
Orbit another one

* **URL Params**  
Required: orbiteeId=[string]

* **Data Params**
```
	{
		orbiterId: string
	}
```

* **Headers**  
Content-Type: application/json

* **Success Response:**  
**Code:** 201  
**Content:**  
`{ success : "Entered their orbit!" }`

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`

#### DELETE /yappers/:orbiteeId/orbiters/:orbiterId
----
Fly away from 'em

* **URL Params**  
Required: orbiteeId=[string], orbiterId=[string]

* **Data Params**  
None  

* **Success Response:**  
**Code:** 204  
**Content:**  
No content

* **Error Response:**  
**Code:** 404  
**Content:**  
`{ error : "Yapper not here fam!" }`