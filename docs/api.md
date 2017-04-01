# WebApi

## Subject

### Object

###### Subject
| Type | Name |
| - | - |
| uuid | id |
| uuid | headTeacherId |
| institue | institue |
| string | name |

### Endpoints

#### POST api/subjects
###### Request
| Type | Name |
| - | - |
| string | name |

###### Response
| Type | Name |
| - | - |
| uuid | id |

#### PUT api/subjects/{id}
###### Request
| Type | Name |
| - | - |
| uuid | id |
| uuid | headTeacherId |
| string | name |

###### Response
Empty

#### GET api/subjects/{id}
###### Request
| Type | Name |
| - | - |
| uuid | id |

###### Response
| Type | Name |
| - | - |
| subject | result |

#### GET api/subjects
###### Request
Empty

###### Response
| Type | Name |
| - | - |
| int | count |
| int | totalCount |
| subject[] | results |

## Survey

### Object

###### Survey
| Type | Name |
| - | - |
| uuid | id |
| date | createdAt |
| string | description |
| question[] | questions |

### Endpoints

#### POST api/surveys/{id}
###### Request
| Type | Name |
| - | - |
| string | description |
| uuid[] | questionIds |

###### Response
| Type | Name |
| - | - |
| uuid | id |

#### PUT api/surveys/{id}
###### Request
| Type | Name |
| - | - |
| uuid | id |
| uuid | description |

###### Response
Empty

#### GET api/surveys/{id}
###### Request
| Type | Name |
| - | - |
| uuid | id |

###### Response
| Type | Name |
| - | - |
| survey | result |

#### GET api/surveys
###### Request
Empty

###### Response
| Type | Name |
| - | - |
| int | count |
| int | totalCount |
| survey[] | results |

## Question

### Object

###### Question
| Type | Name |
| - | - |
| uuid | id |
| string | text |
| string | allowedInputs |

### Endpoints

#### POST api/surveys/{surveyId}/questions
###### Request
Type | Name |
| - | - |
| uuid | surveyId |
| uuid | restrictedInputId |
| string | text |

###### Response
| Type | Name |
| - | - |
| uuid | id |

#### PUT api/surveys/{surveyId}/questions/{id}
###### Request
| Type | Name |
| - | - |
| uuid | id |
| uuid | surveyId |
| uuid | restrictedInputId |
| string | text |

###### Response
Empty

#### GET api/surveys/{surveyId}/questions/{id}
###### Request
Type | Name |
| - | - |
| uuid | id |
| uuid | surveyId |

###### Response
| Type | Name |
| - | - |
| question | result |

#### GET api/surveys/{surveyId}/questions
###### Request
| Type | Name |
| - | - |
| uuid | surveyId |

###### Response
| Type | Name |
| - | - |
| int | count |
| int | totalCount |
| question[] | results |
