import React, { useState, useRef } from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import './AddContent.css';
import photo from "../assets/PostPhoto.png"

const AddContent = () => {
    const [header, setHeader] = useState('');
    const [category, setCategory] = useState('');
    const [subcategory, setSubcategory] = useState('');
    const [content, setContent] = useState('');
    const [image, setImage] = useState(null);

    const fileInputRef = useRef(null);

    const imageUpload = (e) => {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onloadend = () => {
                setImage(reader.result);
            };
            reader.readAsDataURL(file);
        }
    };

    const imageClick = () => {
        fileInputRef.current.click();
    };

    const imageSubmit = (e) => {
        e.preventDefault();
        console.log({
            header,
            category,
            subcategory,
            content,
            image
        });
    };

    return (
        <div className="add-content-container">
            <h2>Create a New Post or Recipe</h2>
            <form onSubmit={imageSubmit} className="add-content-form">
                <input
                    type="text"
                    placeholder="Header"
                    value={header}
                    onChange={(e) => setHeader(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Category (Optional)"
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Subcategory (Optional)"
                    value={subcategory}
                    onChange={(e) => setSubcategory(e.target.value)}
                />
                <ReactQuill
                    theme="snow"
                    value={content}
                    onChange={setContent}
                    modules={AddContent.modules}
                    formats={AddContent.formats}
                />
                <div className="upload-section">
                    <label htmlFor="image-upload" onClick={imageClick}>
                        {image ? (
                            <img src={image} alt="Uploaded Preview" className="image-preview" />
                        ) : (
                            <img src={photo} alt="Default" className="image-preview" />
                        )}
                    </label>
                    <input
                        type="file"
                        id="image-upload"
                        name="images"
                        ref={fileInputRef}
                        style={{ display: 'none' }}
                        onChange={imageUpload}
                    />
                </div>
                <button type="submit" className="submit-button">Submit</button>
            </form>
        </div>
    );
};

AddContent.modules = {
    toolbar: [
        [{ 'list': 'ordered'}, { 'list': 'bullet' }],
        [{ 'script': 'sub'}, { 'script': 'super' }],
        ['bold', 'italic', 'underline', 'strike'],
        [{ 'color': [] }, { 'background': [] }],
        [{ 'align': [] }],
        ['image'],
    ],
    clipboard: {
        matchVisual: false,
    },
};

AddContent.formats = [
    'header', 'font',
    'list', 'bullet',
    'script', 'sub', 'super',
    'bold', 'italic', 'underline', 'strike',
    'color', 'background',
    'align',
    'link', 'image',
    'lineHeight', 'paragraphSpacing',
];

export default AddContent;
