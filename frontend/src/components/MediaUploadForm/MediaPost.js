import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const MediaPost = ({ file, title, description, onDelete, onTitleChange, onDescriptionChange }) => {
  return (
    <div style={{ marginTop: '1rem', border: '1px solid #ccc', padding: '1rem' }}>
      <div style={{ marginBottom: '1rem' }}>
        {file.type.startsWith('image/') ? (
          <img src={URL.createObjectURL(file)} alt="Preview" style={{ maxWidth: '100%', height: 'auto' }} />
        ) : (
          <video controls style={{ maxWidth: '100%' }}>
            <source src={URL.createObjectURL(file)} type={file.type} />
            Your browser does not support the video tag.
          </video>
        )}
      </div>
      <Form.Group controlId="title">
        <Form.Label>Title</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter title"
          value={title}
          onChange={(e) => onTitleChange(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId="description">
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          rows={3}
          placeholder="Enter description"
          value={description}
          onChange={(e) => onDescriptionChange(e.target.value)}
        />
      </Form.Group>
      <Button variant="danger" onClick={onDelete}>Delete</Button>
    </div>
  );
};

export default MediaPost;
