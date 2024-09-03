import React, { useState, useEffect } from 'react';
import './Auth.css';

const Auth = ({ isOpen, onClose }) => {
    const [isLogin, setIsLogin] = useState(true);

    useEffect(() => {
        const KeyDown = (event) => {
            if (event.key === 'Escape') {
                onClose();
            }
        };

        if (isOpen) {
            document.addEventListener('keydown', KeyDown);
        }

        return () => {
            document.removeEventListener('keydown', KeyDown);
        };
    }, [isOpen, onClose]);

    if (!isOpen) return null;

    return (
        <div className="auth-overlay">
            <div className="auth">
                <h2>{isLogin ? 'Login' : 'Register'}</h2>
                <form className="auth-form">
                    {isLogin ? (
                        <>
                            <input type="text" placeholder="Username or Email" />
                            <input type="password" placeholder="Password" />
                            <button type="submit" className="submit-button">Login</button>
                        </>
                    ) : (
                        <>
                            <input type="text" placeholder="Username" />
                            <input type="email" placeholder="Email" />
                            <input type="password" placeholder="Password" />
                            <button type="submit" className="submit-button">Register</button>
                        </>
                    )}

                    <div className="social-login">
                        <button className="social-button facebook">Login with Facebook</button>
                        <button className="social-button google">Login with Google</button>
                    </div>

                    <p className="toggle-auth">
                        {isLogin ? "Don't have an account?" : "Already have an account?"}
                        <span onClick={() => setIsLogin(!isLogin)}>
                            {isLogin ? ' Register' : ' Login'}
                        </span>
                    </p>
                </form>
            </div>
        </div>
    );
};

export default Auth;
