import React from "react";
import "./HomePage.css";
import breakfast from "../assets/breakfast.png";
import lunch from "../assets/lunch.png";
import dinner from "../assets/dinner.png";
import snack from "../assets/snack.png";
import desserts from "../assets/deserts.png";
import vegan from "../assets/vegan.jpeg";
import fruit from "../assets/fruits.jpeg";


const categories = [
    { name: "Breakfast", image: breakfast },
    { name: "Lunch", image: lunch },
    { name: "Dinner", image: dinner },
    { name: "Snacks", image: snack },
    { name: "Desserts", image: desserts },
    { name: "Vegan Food", image: vegan},
    { name: "Fruits", image: fruit}

];

const HomePage = () => {
    return (
        <div className="HomePage">
            <div className="food-categories">
                {categories.map((category, index) => (
                    <div key={index} className="category-item">
                        <img src={category.image} alt={category.name} className="category-image" />
                        <div className="category-name">{category.name}</div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default HomePage;
