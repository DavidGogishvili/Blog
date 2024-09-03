import React from 'react';
import './Footer.css';
import upArrow from "../assets/upArrow.png"

const scrollToTop = () => {
    window.scrollTo({
        top: 0,
        behavior: "smooth",
    });
};

const Footer = () => {
    return (
        <footer className="footer">
            <div className="footer-content">
                <p>&copy; {new Date().getFullYear()} Food Blog. All rights reserved.</p>
                <p>
                    <a href="#privacy-policy">Privacy Policy</a> |
                    <a href="#terms-of-service"> Terms of Service</a> |
                    <a href="#contact"> Contact Us</a>
                </p>
                <div className="social-media">
                    <a href="https://facebook.com" target="_blank" rel="noopener noreferrer">
                        <img src="/icons/facebook.png" alt="Facebook"/>
                    </a>

                    <a href="https://instagram.com" target="_blank" rel="noopener noreferrer">
                        <img src="/icons/instagram.png" alt="Instagram"/>
                    </a>

                </div>
                <button className="scroll-to-top" onClick={scrollToTop}>
                    <img src={upArrow} alt="Scroll to top"/>
                </button>
            </div>
        </footer>
    );
};

export default Footer;