# customer-device-hex-version-api

This api is an example but lacks in test, exception.

## post__api_v1_customer

`POST /api/v1/customer`

> Body parameter

```json
{
  "nome": "Mario",
  "cognome": "Rossi",
  "codiceFiscale": "RSSMRA30A01H501I",
  "indirizzo": "Via Venezia 13",
  "devices": [
    {
      "status": "ACTIVE"
    }
  ]
}
```

<h3 id="post__api_v1_customer-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[CustomerCreateViewModel](#schemacustomercreateviewmodel)|true|Dati del cliente da creare|

> Example responses

> Cliente creato con successo

```json
{
  "nome": "Mario",
  "cognome": "Rossi",
  "codiceFiscale": "RSSMRA30A01H501I",
  "indirizzo": "Via Venezia 13",
  "devices": [
    {
      "id": "f5b5c0d0-5f8a-11eb-ae93-0242ac130002",
      "status": "ACTIVE"
    }
  ]
}
```

<h3 id="post__api_v1_customer-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Cliente creato con successo|[CustomerCreateViewModel](#schemacustomercreateviewmodel)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Codice fiscale non valido|None|
|409|[Conflict](https://tools.ietf.org/html/rfc7231#section-6.5.8)|Codice fiscale già presente|None|
|500|[Internal Server Error](https://tools.ietf.org/html/rfc7231#section-6.6.1)|Errore interno|None|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-device-hex-version-api-customer-find-resource-impl">Customer Find Resource Impl</h1>

## get__api_v1_customer_{codiceFiscale}

`GET /api/v1/customer/{codiceFiscale}`

<h3 id="get__api_v1_customer_{codicefiscale}-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|codiceFiscale|path|string|true|Codice fiscale del cliente|

> Example responses

> 200 Response

```json
{
  "nome": "string",
  "cognome": "string",
  "codiceFiscale": "string",
  "indirizzo": "string",
  "devices": [
    {
      "id": "497f6eca-6276-4993-bfeb-53cbbbba6f08",
      "status": "ACTIVE"
    }
  ]
}
```

<h3 id="get__api_v1_customer_{codicefiscale}-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Cliente trovato con successo|[CustomerFindViewModel](#schemacustomerfindviewmodel)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Codice fiscale non valido|None|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Cliente non trovato|None|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-device-hex-version-api-update-customer-address-resource-impl">Update Customer Address Resource Impl</h1>

## patch__api_v1_customer_{codiceFiscale}_address

`PATCH /api/v1/customer/{codiceFiscale}/address`

> Body parameter

```json
{
  "indirizzo": "Via Roma"
}
```

<h3 id="patch__api_v1_customer_{codicefiscale}_address-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|codiceFiscale|path|string|true|codiceFiscale of customer|
|body|body|[AddressViewModel](#schemaaddressviewmodel)|true|Address of customer|

> Example responses

> 200 Response

```json
{}
```

<h3 id="patch__api_v1_customer_{codicefiscale}_address-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="patch__api_v1_customer_{codicefiscale}_address-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-device-hex-version-api-device-find-resource-impl">Device Find Resource Impl</h1>

## get__api_v1_device_{id}

`GET /api/v1/device/{id}`

<h3 id="get__api_v1_device_{id}-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|[UUID](#schemauuid)|true|none|

> Example responses

> 200 Response

```json
{
  "id": "497f6eca-6276-4993-bfeb-53cbbbba6f08",
  "status": "ACTIVE"
}
```

<h3 id="get__api_v1_device_{id}-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[DeviceViewModel](#schemadeviceviewmodel)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-device-hex-version-api-update-device-status-resource-impl">Update Device Status Resource Impl</h1>

## patch__api_v1_device_{id}_status

`PATCH /api/v1/device/{id}/status`

> Body parameter

```json
{
  "status": "ACTIVE"
}
```

<h3 id="patch__api_v1_device_{id}_status-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|string|true|Id of device|
|body|body|[DeviceStatusViewModel](#schemadevicestatusviewmodel)|true|Status of device|

#### Enumerated Values

|Parameter|Value|
|---|---|
|body|ACTIVE|
|body|INACTIVE|
|body|LOST|

> Example responses

> 200 Response

```json
{}
```

<h3 id="patch__api_v1_device_{id}_status-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="patch__api_v1_device_{id}_status-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_AddressViewModel">AddressViewModel</h2>
<!-- backwards compatibility -->
<a id="schemaaddressviewmodel"></a>
<a id="schema_AddressViewModel"></a>
<a id="tocSaddressviewmodel"></a>
<a id="tocsaddressviewmodel"></a>

```json
{
  "indirizzo": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|indirizzo|string|true|none|none|

<h2 id="tocS_CustomerCreateViewModel">CustomerCreateViewModel</h2>
<!-- backwards compatibility -->
<a id="schemacustomercreateviewmodel"></a>
<a id="schema_CustomerCreateViewModel"></a>
<a id="tocScustomercreateviewmodel"></a>
<a id="tocscustomercreateviewmodel"></a>

```json
{
  "nome": "string",
  "cognome": "string",
  "codiceFiscale": "string",
  "indirizzo": "string",
  "devices": [
    {
      "status": "ACTIVE"
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|nome|string|true|none|none|
|cognome|string|true|none|none|
|codiceFiscale|string|true|none|none|
|indirizzo|string|true|none|none|
|devices|[[DeviceCreateViewModel](#schemadevicecreateviewmodel)]|false|none|none|

<h2 id="tocS_CustomerFindViewModel">CustomerFindViewModel</h2>
<!-- backwards compatibility -->
<a id="schemacustomerfindviewmodel"></a>
<a id="schema_CustomerFindViewModel"></a>
<a id="tocScustomerfindviewmodel"></a>
<a id="tocscustomerfindviewmodel"></a>

```json
{
  "nome": "string",
  "cognome": "string",
  "codiceFiscale": "string",
  "indirizzo": "string",
  "devices": [
    {
      "id": "497f6eca-6276-4993-bfeb-53cbbbba6f08",
      "status": "ACTIVE"
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|nome|string|true|none|none|
|cognome|string|true|none|none|
|codiceFiscale|string|true|none|none|
|indirizzo|string|true|none|none|
|devices|[[DeviceViewModel](#schemadeviceviewmodel)]|false|none|none|

<h2 id="tocS_DeviceCreateViewModel">DeviceCreateViewModel</h2>
<!-- backwards compatibility -->
<a id="schemadevicecreateviewmodel"></a>
<a id="schema_DeviceCreateViewModel"></a>
<a id="tocSdevicecreateviewmodel"></a>
<a id="tocsdevicecreateviewmodel"></a>

```json
{
  "status": "ACTIVE"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|status|[DeviceStatusViewModel](#schemadevicestatusviewmodel)|true|none|none|

<h2 id="tocS_DeviceStatusViewModel">DeviceStatusViewModel</h2>
<!-- backwards compatibility -->
<a id="schemadevicestatusviewmodel"></a>
<a id="schema_DeviceStatusViewModel"></a>
<a id="tocSdevicestatusviewmodel"></a>
<a id="tocsdevicestatusviewmodel"></a>

```json
"ACTIVE"

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|*anonymous*|ACTIVE|
|*anonymous*|INACTIVE|
|*anonymous*|LOST|

<h2 id="tocS_DeviceViewModel">DeviceViewModel</h2>
<!-- backwards compatibility -->
<a id="schemadeviceviewmodel"></a>
<a id="schema_DeviceViewModel"></a>
<a id="tocSdeviceviewmodel"></a>
<a id="tocsdeviceviewmodel"></a>

```json
{
  "id": "497f6eca-6276-4993-bfeb-53cbbbba6f08",
  "status": "ACTIVE"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|[UUID](#schemauuid)|false|none|none|
|status|[DeviceStatusViewModel](#schemadevicestatusviewmodel)|false|none|none|

<h2 id="tocS_UUID">UUID</h2>
<!-- backwards compatibility -->
<a id="schemauuid"></a>
<a id="schema_UUID"></a>
<a id="tocSuuid"></a>
<a id="tocsuuid"></a>

```json
"497f6eca-6276-4993-bfeb-53cbbbba6f08"

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|string(uuid)|false|none|none|

