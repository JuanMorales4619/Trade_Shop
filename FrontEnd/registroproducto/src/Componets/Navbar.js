import { Navbar, Nav, Container } from "react-bootstrap"
import { Outlet, Link } from "react-router-dom"
import '../Style-sheets/Navbar.css'
const Topbar = () => {
    return(
       <>    
       <Navbar className="navBg" variant="dark" expand="lg">
        <Container>
            <Navbar.Brand as={Link} to="/" ><img src="https://lh3.googleusercontent.com/udkj8QtsYyj3Hqqcw07OhYt5nV58rAsDAvlqDD0bs9OoKd98juzU2uCQXlMiMKjyZeo=s85" alt="The logo of company trade shop" width="50" height="50"/></Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
                <Nav.Link as={Link} to="/" >Inicio</Nav.Link>
                <Nav.Link as={Link} to="/create">Nueva publicacion</Nav.Link>
                <Nav.Link as={Link} to="/find">Mis publicaciones</Nav.Link>                
            </Nav>
            </Navbar.Collapse>
        </Container>
        </Navbar>  

        <section>
            <Outlet></Outlet>
        </section> 
       </> 
    )
}
export default Topbar