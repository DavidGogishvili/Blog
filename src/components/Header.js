import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Header.css";
import SearchIcon from "../assets/search-icon.png";
import Logo from "../assets/Logo.png";
import Login from "../assets/login.png";
import Auth from "./Auth";

const Header = () => {
    const [isClicked, setIsClicked] = useState(false);
    const [isAuthDialogOpen, setIsAuthDialogOpen] = useState(false);
    const navigate = useNavigate();

    const toggleAuthDialog = () => setIsAuthDialogOpen(!isAuthDialogOpen);

    const SearchClick = () => {
        setIsClicked(true);
    };

    const Blur = (e) => {
        if (!e.currentTarget.contains(e.relatedTarget) && e.relatedTarget !== document.querySelector('.search-icon')) {
            setIsClicked(false);
        }
    };

    const LogoClick = () => {
        setIsClicked(false);
        navigate('/');
    };

    const RecipesClick = () => {
        navigate('/recipes/find');
    };

    const postsClick = () => {
        setIsClicked(false);
        navigate('/posts/find')
    }

    return (
        <header className="header">
            <img src={Logo} alt="Logo" className="logo-icon" onClick={LogoClick} />
            <h1> Let's Eat Amazing Food Together! </h1>

            <input
                type="text"
                className={`search-bar ${isClicked ? "clicked" : ""}`}
                placeholder="Search"
                onBlur={() => setIsClicked(false)}
                onFocus={() => setIsClicked(true)}
            />

            <img
                src={SearchIcon}
                alt="Search Icon"
                className={`search-icon2 ${isClicked ? "visible" : ""}`}
            />
            <Auth isOpen={isAuthDialogOpen} onClose={() => setIsAuthDialogOpen(false)} />
            <nav className="menu">
                <img
                    src={SearchIcon}
                    alt="Search Icon"
                    className="search-icon"
                    onClick={SearchClick}
                    onBlur={Blur}
                />
                <a href="#about">About Us</a> |
                <a href="#recipes" onClick={RecipesClick}>Recipes</a>
                <a href="#Posts" onClick={postsClick} >Blog Posts</a>
                <img className="login-icon" src={Login} alt="login-form" onClick={toggleAuthDialog} />
            </nav>
        </header>
    );
};

export default Header;
