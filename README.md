# Blog Application

This is a full-stack blog application with a React front-end and a Spring Boot back-end. The application allows users to register, log in, create, and view blog posts, with authentication and authorization features implemented using JWT.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

This project is a blogging platform where users can:
- Create an account
- Log in with JWT-based authentication
- Write and publish blog posts
- View and interact with content

The project uses React for the front-end and Spring Boot with a PostgreSQL database for the back-end.

## Features

- **Authentication**: JWT-based login and registration system.
- **Content Management**: Create, update, and delete blog posts.
- **Rich Text Editor**: Use editors like Froala, Quill, or CKEditor for writing posts.
- **Security**: Protected API routes for authenticated users.

## Technologies Used

- **Front-end**: 
  - React (JavaScript)
  - Axios for HTTP requests
  - React Router for client-side routing
  - Rich Text Editors: CKEditor, Quill, and Froala
  
- **Back-end**: 
  - Spring Boot (Java)
  - Spring Security (for authentication and authorization)
  - PostgreSQL (for database)
  - JWT (for authentication)
  
- **Build Tools**:
  - Gradle (for back-end)
  - NPM (for front-end)

## Installation

### Prerequisites

- Java 17+
- Node.js and npm
- PostgreSQL
- IntelliJ IDEA or another IDE
- WebStorm (optional, for front-end)

### Step 1: Clone the Repository

```bash
git clone https://github.com/DavidGogishvili/Blog
cd Blog
