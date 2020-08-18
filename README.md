# Application usage 
## Reservation endpoints 
```ruby
String BASE_URL = "localhost:8090/reservations"
```
| Method | URL  | Description |
| --- | --- | --- |
| `POST` | `{`***BASE_URL***`}`| Book choosen room |
| `GET` | `{`***BASE_URL***/***{id}***/***stop***`}` | Stop reservation of the room |
## Employee endpoints 
```ruby
String BASE_URL = "localhost:8090/employees"
```
| Method | URL  | Description |
| --- | --- | --- |
| `GET` | `{`***BASE_URL***/***{id}***`}` | Get employee by id |
| `GET` | `{`***BASE_URL***/***types***`}` | Get employee types |
| `GET` | `{`***BASE_URL***/***{id}***/***reservations***`}` | Get all reservations for the employee |
| `POST` | `{`***BASE_URL***`}`| Create employee |
| `POST` | `{`***BASE_URL***/***sign-in***`}`| Sign-in the employee, acts like creation but return 200 ststus with model :disappointed: |
| `GET` | `{`***BASE_URL***/***{id}***/***stop***`}` | Stop reservation of the room |
## Room endpoints 
```ruby
String BASE_URL = "localhost:8090/rooms"
```
| Method | URL  | Description |
| --- | --- | --- |
| `GET` | `{`***BASE_URL***/`}` | Get rooms with pagination |
| `GET` | `{`***BASE_URL***/***{id}***`}` | Get room by id |
| `POST` | `{`***BASE_URL***`}`| Create room |
