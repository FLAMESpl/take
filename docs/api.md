# WebApi

## Institutes

### Object

###### Insitute
Type | Name
- | -
uuid | id
string | name
subject[] | subjects

### Endpoints

##### POST api/institutes
###### Request
Type | Name
- | -
string | name

###### Response
Type | Name
- | -
uuid | id

##### PUT api/institute/{id}
###### Request
Type | Name
- | -
uuid | id
string | name

###### Response
Empty

##### GET api/institute/{id}
###### Request
Type | Name
- | -
uuid | id

###### Response
Type | Name
- | -
institute | result

##### GET api/institute
###### Request
Empty

###### Response
Type | Name
- | -
int | count
int | totalCount
institute[] | results

## Subject

### Object

###### Subject
Type | Name
- | -
uuid | id
uuid | headTeacherId
institue | institue
string | name

### Endpoints

##### POST api/institutes/{institueId}/subjects
###### Request
Type | Name
- | -
uuid | institueId
string | name

###### Response
Type | Name
- | -
uuid | id

##### PUT api/institute/{institueId}/subjects/{id}
###### Request
Type | Name
- | -
uuid | id
uuid | institueId
uuid | headTeacherId
string | name

###### Response
Empty

##### GET api/institute/{institueId}/subjects/{id}
###### Request
Type | Name
- | -
uuid | id
uuid | institueId

###### Response
Type | Name
- | -
subject | result

##### GET api/institute/{institueId}/subjects
###### Request
Type | Name
- | -
uuid | instituteId

###### Response
Type | Name
- | -
int | count
int | totalCount
subject[] | results

## Survey

### Object

###### Survey
Type | Name
- | -
uuid | id
date | createdAt
string | description
question[] | questions

### Endpoints

##### POST api/surveys/{id}
###### Request
Type | Name
- | -
string | description
uuid[] | questionIds

###### Response
Type | Name
- | -
uuid | id

##### PUT api/surveys/{id}
###### Request
Type | Name
- | -
uuid | id
uuid | description

###### Response
Empty

##### GET api/surveys/{id}
###### Request
Type | Name
- | -
uuid | id

###### Response
Type | Name
- | -
survey | result

##### GET api/surveys
###### Request
Empty

###### Response
Type | Name
- | -
int | count
int | totalCount
survey[] | results

## Question

### Object

###### Question
Type | Name
- | -
uuid | id
string | text
string | allowedInputs

### Endpoints

##### POST api/surveys/{surveyId}/questions
###### Request
Type | Name
- | -
uuid | surveyId
uuid | restrictedInputId
string | text

###### Response
Type | Name
- | -
uuid | id

##### PUT api/surveys/{surveyId}/questions/{id}
###### Request
Type | Name
- | -
uuid | id
uuid | surveyId
uuid | restrictedInputId
string | text

###### Response
Empty

##### GET api/surveys/{surveyId}/questions/{id}
###### Request
Type | Name
- | -
uuid | id
uuid | surveyId

###### Response
Type | Name
- | -
question | result

##### GET api/surveys/{surveyId}/questions
###### Request
Type | Name
- | -
uuid | surveyId

###### Response
Type | Name
- | -
int | count
int | totalCount
question[] | results