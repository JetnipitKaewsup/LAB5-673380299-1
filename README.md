# Coffee REST API with Spring Boot

โปรเจ็กต์ฝึกพัฒนา **REST API** ด้วย **Spring Boot** โดยเน้นเรียนรู้พื้นฐานของ

- HTTP Methods (GET, POST, PUT, DELETE)
- Layered Design (Controller / Service / Model)
- การรับ–ส่งข้อมูลแบบ JSON
- การเก็บข้อมูลใน Memory ด้วย `List<Coffee>`


## เทคโนโลยีที่ใช้

- Java 17+
- Spring Boot
- Maven

---

## โครงสร้างโปรเจ็กต์

```
src
└── main
    └── java
        └── com.example.demo
            ├── controller
            │     CoffeeController.java
            ├── model
            │     Coffee.java
            ├── service
            │     CoffeeService.java
            └── DemoApplication.java

newMenu.json
updateMenu.json
pom.xml
README.md
```

### หน้าที่ของแต่ละ Layer

### Model

เก็บโครงสร้างข้อมูลของเมนูกาแฟ

```java
Coffee
```

ประกอบด้วย

- id
- name
- price

---

### Service

จัดการ Business Logic

- เก็บข้อมูลใน `List<Coffee>`
- เพิ่มข้อมูล
- ค้นหา
- แก้ไข
- ลบ

---

### Controller

รับ HTTP Request

เรียกใช้ Service

ส่งผลลัพธ์กลับเป็น JSON

---
# HTTP Methods ที่ใช้

| Method | Endpoint | รายละเอียด |
|---------|----------|------------|
| GET | /coffees | ดูเมนูทั้งหมด |
| GET | /coffees/{id} | ดูเมนูตาม id |
| POST | /coffees | เพิ่มเมนู |
| PUT | /coffees/{id} | แก้ไขเมนู |
| DELETE | /coffees/{id} | ลบเมนู |

---

## วิธีรันโปรเจ็กต์ 
### วิธีที่ 1 (Maven)

เปิด Terminal ที่โฟลเดอร์โปรเจ็กต์

```bash
mvn spring-boot:run
```

### วิธีที่ 2 (VS Code / IntelliJ)

เปิดไฟล์

```
DemoApplication.java
```

แล้วกด

```
Run
```

---

## เมื่อรันสำเร็จ

Console จะขึ้นข้อความประมาณ

```
Tomcat started on port 8080 (http)
Started DemoApplication
```

Server จะทำงานที่

```
http://localhost:8080
```

---

# REST API

Base URL

```
http://localhost:8080
```

ตัวอย่างการใช้คำสั่ง curl เพื่อทดสอบ
---

## 1. GET - ดูเมนูทั้งหมด

Method

```
GET
```

Endpoint

```
/coffees
```

ตัวอย่างคำสั่ง

```
curl http://localhost:8080/coffees
```

Response

```json
[
  {
    "id": 1,
    "name": "Espresso",
    "price": 55
  },
  {
    "id": 2,
    "name": "Latte",
    "price": 70
  },
  {
    "id": 3,
    "name": "Mocha",
    "price": 80
  }
]
```

---

## 2. GET by id - ดูเมนูตาม ID

Method

```
GET
```

Endpoint

```
/coffees/{id}
```

ตัวอย่างคำสั่ง

```
curl http://localhost:8080/coffees/2
```

Response

```json
{
  "id": 2,
  "name": "Latte",
  "price": 70.0
}
```

---

## 3. POST - เพิ่มเมนูใหม่

Method

```
POST
```

Endpoint

```
/coffees
```

ตัวอย่าง

```
curl.exe -X POST http://localhost:8080/coffees -H "Content-Type: application/json" --data-binary "@newMenu.json"
```

```json
{
  "id": 4,
  "name": "Americano",
  "price": 70
}
```

Response

```
Coffee Added
```

---

## 4. PUT - แก้ไขข้อมูล

Method

```
PUT
```

Endpoint

```
/coffees/{id}
```

ตัวอย่าง

```
curl.exe -X PUT http://localhost:8080/coffees/4 -H "Content-Type: application/json" --data-binary "@updateMenu.json"
```

Request Body

```json
{
  "name": "Iced Latte",
  "price": 75
}
```

Response

```
Updated
```

---

## 5. DELETE - ลบเมนู

Method

```
DELETE
```

Endpoint

```
/coffees/{id}
```

ตัวอย่าง

```
curl.exe -X DELETE http://localhost:8080/coffees/4
```

Response

```
Deleted
```

# หมายเหตุ

ข้อมูลทั้งหมดถูกเก็บไว้ในหน่วยความจำ (`List<Coffee>`)

เมื่อปิดโปรแกรม ข้อมูลที่เพิ่มหรือแก้ไขจะหายไป และเมื่อเปิดใหม่ ระบบจะเริ่มต้นด้วยข้อมูลตัวอย่างเดิม

# รายงานผลการทดสอบ
[Lab 5 Software Design 673380299-1.pdf](https://github.com/JetnipitKaewsup/LAB5-673380299-1/blob/6550c6f5244de422706ee56b54e5ed02050baddd/Lab%205%20Software%20Design%20673380299-1.pdf)
