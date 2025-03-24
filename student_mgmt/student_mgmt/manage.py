django-admin startproject student_mgmt<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

    <h2>Student Registration</h2>

    <form action="/submit_student" method="post">  
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>

        <label for="class">Class:</label><br>
        <input type="text" id="class" name="class"><br><br>

        <label>Gender:</label><br>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br>
        <input type="radio" id="other" name="gender" value="other">
        <label for="other">Other</label><br><br>

        <label for="section">Section:</label><br>
        <select id="section" name="section">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select><br><br>

        <label for="dob">Date of Birth:</label><br>
        <input type="date" id="dob" name="dob"><br><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>