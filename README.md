# VSB-FootballClub WebApplication

This is a web application project for VSB Football Club, designed to manage match details, player registration, audience ticket booking, and administration functionalities.

## Features

1. **Match Management**
   - **AddMatchDetails**: Admin can add match details including title, place, and date.
   - **UpcomingDetails**: Displays upcoming match details for the audience.

2. **Player Registration**
   - **RegisterPlayer**: Players can register for matches by providing their details including name, age, city, playing position, and profile picture.

3. **Audience Services**
   - **TicketBooking**: Allows the audience to book tickets for upcoming matches.

4. **Admin Panel**
   - **Admin.html**: Admin interface for managing match details and viewing player lists.

5. **Viewing Data**
   - **ViewPlayerList**: Displays the list of registered players.
   - **UpcomingDetails**: Displays upcoming match details.

## Technologies Used

- **Java Servlets**: Backend logic and handling HTTP requests.
- **MySQL Database**: Storage and retrieval of match details, player information, and booking data.
- **HTML/CSS**: Frontend for user interfaces and styling.
- **Servlet Annotations**: For mapping servlets to specific URLs.
- **Multipart Form Handling**: For uploading player profile pictures.

## Files Structure

- **src/com/fc/**: Java servlets and DAO classes.
- **WebContent/**: HTML files, CSS files, and image resources.
- **WEB-INF/lib/**: External JAR files for database connectivity.

## Setup Instructions

1. **Database Configuration**:
   - Install MySQL and create a database named `vsbfc`.
   - Execute the SQL scripts provided in `/database_scripts` for table creation and sample data insertion.

2. **Environment Setup**:
   - Ensure Java Development Kit (JDK) and Apache Tomcat server are installed.
   - Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).

3. **Deployment**:
   - Configure Tomcat server in your IDE and deploy the project.
   - Access the application using `http://localhost:8080/VSBFootballClub`.

## Usage

- Access different functionalities through respective URLs:
  - Admin: `http://localhost:8080/VSBFootballClub/Admin.html`
  - Player Registration: `http://localhost:8080/VSBFootballClub/RegisterPlayer`
  - Audience Ticket Booking: `http://localhost:8080/VSBFootballClub/TicketBooking`
  - View Upcoming Matches: `http://localhost:8080/VSBFootballClub/UpcomingDetails`

## Contributor

- [Karthikeyan](https://github.com/KarthikeyanM14)
