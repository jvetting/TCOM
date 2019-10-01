 <?php
$servername = "coms-309-jr-6.misc.iastate.edu";
$username = "user";
$password = "Tcomjtaj_69";
$dbname = "tiles";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, centerX, centerY FROM tiles";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " X: " . $row["centerX"]. " Y:" . $row["centerY"]. "<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?> 