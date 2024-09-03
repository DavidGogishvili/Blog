import React, { useState } from 'react';
import "./Profile.css"
import man from "../assets/man.png";
import photo from "../assets/photo-camera.png";
import plus from    "../assets/plus.png"


const Profile = () => {
    const [profilePicture, setProfilePicture] = useState(man);

    const EditClick = () => {
        document.getElementById('fileInput').click();
    };

    const FileChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = (e) => {
                setProfilePicture(e.target.result);
            };
            reader.readAsDataURL(file);
        }
    };

    return (
        <div className="dialog-overlay">
            <div className="profile-dialog">
                <div className="profile-picture-container">
                    <img
                        src={profilePicture}
                        alt="Profile"
                        className="profile-picture"
                    />
                    <h2 className="email">example@example.com</h2>

                    <div className="edit-div" onClick={EditClick}>
                        <img className="edit-icon" src={photo} alt="edit-icon"/>
                    </div>
                </div>

                <input
                    type="file"
                    id="fileInput"
                    style={{display: 'none'}}
                    accept="image/*"
                    onChange={FileChange}
                />


                <div className="plus-div">
                    <div className="plus-frame">
                        <img className="plus" src={plus} alt="plus"/>
                    </div>
                </div>

                <form className="profile-form">
                    <input type="text" placeholder="Name"/>

                    <input type="text" placeholder="Last Name"/>
                    <input type="date" placeholder="Date of Birth"/>
                    <input type="tel" placeholder="Phone Number"/>
                    <input type="text" placeholder="Gender"/>
                    <input type="text" placeholder="Address"/>


                </form>

                <div className="actions">
                    <button className="action-button">My Recipes</button>
                    <button className="action-button">My Blog Posts</button>
                    <button className="action-button">My Comments</button>


                </div>

                <button type="submit" className="save-button">Save/Update Profile</button>
                <button type="sign-out" className="sign-out">Sign Out</button>

            </div>

        </div>
    );
};

export default Profile;
