import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Body from './components/Body';
import Profile from './components/Profile';
import AddContent from './components/AddContent';

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                <main>
                    <Routes>
                        <Route path="/" element={<Body />} />
                        <Route path="/profile" element={<Profile />} />
                        <Route path="/add-content" element={<AddContent />} />
                    </Routes>
                </main>
                <Footer />
            </div>
        </Router>
    );
}

export default App;
