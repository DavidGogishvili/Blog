import React, { useState } from 'react';
import './Body.css';
import HomePage from "./HomePage";
import avocado from "../assets/avocado.png";

const posts = [
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი ",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
    {
        title: "Delicious Pancakes",
        content: "ძალიან მაგარი და გემრიელი ავოკადოს სალათის რეცეპტი",
        image: avocado,
        type: "Recipe",
        author: "John Doe",
        categories: ["Breakfast", "Easy"],
        comments: ["Great recipe!", "My kids loved it!", "Definitely making this again."],
        publishDate: "2024-08-30"
    },
];

const formatDate = (dateString) => {
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return new Date(dateString).toLocaleDateString(undefined, options);
};

const Body = () => {
    const [expandedPosts, setExpandedPosts] = useState([]);

    const toggleReadMore = (index) => {
        if (expandedPosts.includes(index)) {
            setExpandedPosts(expandedPosts.filter(i => i !== index));
        } else {
            setExpandedPosts([...expandedPosts, index]);
        }
    };

    return (
        <div className="body">
            <HomePage />
            <div className="posts">
                {posts.map((post, index) => {
                    const isExpanded = expandedPosts.includes(index);
                    const postContent = isExpanded ? post.content : post.content.substring(0, 350);
                    return (
                        <div key={index} className="post">
                            <img src={post.image} alt={post.title} className="post-image" />
                            <div className="post-info">
                                <div className="post-header">
                                    <div className="post-type">{post.type}</div>
                                    <div className="post-author">{post.author}</div>
                                    <div className="post-categories">
                                        {post.categories.map((category, i) => (
                                            <span key={i}>{category}</span>
                                        ))}
                                    </div>
                                </div>
                                <h2 className="post-title">{post.title}</h2>
                                <p className="post-content">
                                    {postContent}
                                    {post.content.length > 500 && (
                                        <>
                                            {!isExpanded ? (
                                                <span className="read-more" onClick={() => toggleReadMore(index)}> ..Read More</span>
                                            ) : (
                                                <span className="read-more" onClick={() => toggleReadMore(index)}> Read Less</span>
                                            )}
                                        </>
                                    )}
                                    <time className="published">
                                        {formatDate(post.publishDate)}
                                    </time>
                                </p>
                                <div className="post-footer">
                                    {isExpanded && <a href="#post-page">Go to the post page</a>}
                                </div>
                            </div>
                            <a href="#comments" className="comments-link">Comments</a>
                        </div>
                    );
                })}
            </div>
        </div>
    );
};

export default Body;
