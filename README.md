# StudentRecordSystem
This is a **Java-based console application** for managing student records using **Oracle Database** as the backend. It supports adding, viewing, updating, and deleting student data efficiently.

## Technologies Used

- **Java (JDK 17+)**
- **JDBC (Java Database Connectivity)**
- **Oracle Database 19c**
- **Eclipse/VS Code** (for development)
- **Git + GitHub** (for version control)

## Features

- Add new student records
- View all students
- Update student details
- Delete student by ID
- Clean exception handling and user messages

## Project Structure
udentRecordSystem/
├── src/
│ ├── com/student/
│ │ ├── Student.java
│ │ ├── StudentDao.java
│ │ └── Main.java
├── lib/ (contains Oracle JDBC driver)
├── DB Script.sql
├── README.md

## Oracle Database Table Script

```sql
CREATE TABLE student (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    marks NUMBER,
    grade VARCHAR2(10)
);

How to Run
Clone this repository

bash
Copy code
git clone https://github.com/shaukatali123/StudentRecordSystem.git
Open the project in Eclipse or any Java IDE

Add Oracle JDBC jar to your project build path

Configure your Oracle DB in StudentDao.java:

java
Copy code
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "your_user";
String pass = "your_password";
Run Main.java to start the program.

Sample Output (Console)
markdown
Copy code
1. Add
2. View
3. Delete
4. Update
5. Exit
Enter your choice:

Author
Shaukat Ali
Java Developer | 2024 Graduate
Passionate about building backend systems using Oracle & Java.
