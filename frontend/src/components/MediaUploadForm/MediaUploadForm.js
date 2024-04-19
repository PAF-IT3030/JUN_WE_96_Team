import React, { useState } from 'react';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import MediaPost from './MediaPost';

const MediaUploadForm = () => {
  const [mediaFiles, setMediaFiles] = useState([]);
  const [titles, setTitles] = useState([]);
  const [descriptions, setDescriptions] = useState([]);
  const [uploading, setUploading] = useState(false);

  const handleDrop = (event) => {
    event.preventDefault();
    const files = Array.from(event.dataTransfer.files);
    handleFiles(files);
  };

  const handleFiles = (files) => {
    const newFiles = files.filter(file => (
      file.type.startsWith('image/') || (file.type.startsWith('video/') && file.size <= 30 * 1024 * 1024)
    ));
    const updatedMediaFiles = [...mediaFiles, ...newFiles];
    setMediaFiles(updatedMediaFiles.slice(0, 3));

    const updatedTitles = [...titles];
    const updatedDescriptions = [...descriptions];
    newFiles.forEach(() => {
      updatedTitles.push('');
      updatedDescriptions.push('');
    });
    setTitles(updatedTitles);
    setDescriptions(updatedDescriptions);
  };

  const handleDelete = (index) => {
    const updatedMediaFiles = [...mediaFiles];
    updatedMediaFiles.splice(index, 1);
    setMediaFiles(updatedMediaFiles);

    const updatedTitles = [...titles];
    updatedTitles.splice(index, 1);
    setTitles(updatedTitles);

    const updatedDescriptions = [...descriptions];
    updatedDescriptions.splice(index, 1);
    setDescriptions(updatedDescriptions);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const isValid = titles.every((title) => title.trim() !== '') && descriptions.every((description) => description.trim() !== '');
    if (!isValid) {
      alert('Please provide a title and description for each media file.');
      return;
    }
    setUploading(true);
    // Simulate upload delay
    await new Promise((resolve) => setTimeout(resolve, 2000));
    setUploading(false);
    // Reset form
    setMediaFiles([]);
    setTitles([]);
    setDescriptions([]);
  };

  return (
    <Container className="mx-auto">
      <Card
        border="light"
        style={{ width: '30rem' }}
        onDrop={handleDrop}
        onDragOver={(event) => event.preventDefault()}
      >
        <Card.Header style={{ backgroundColor: '#F0F2F5', borderBottom: '1px solid #dddfe2' }}>
          <h5 style={{ color: '#1877F2', marginBottom: '0' }}>Create Post</h5>
        </Card.Header>
        <Card.Body>
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="media">
              <Form.Label style={{ color: '#1877F2' }}>Upload Media (Max 3, Max 30s)</Form.Label>
              <div
                className="dropzone"
                style={{ cursor: 'pointer', border: '2px dashed #ccc', padding: '1rem', textAlign: 'center' }}
              >
                <input
                  type="file"
                  accept="image/*,video/*"
                  multiple
                  style={{ display: 'none' }}
                  onChange={(event) => handleFiles(event.target.files)}
                />
                <p>Drag 'n' drop up to 3 files here, or click to select files</p>
              </div>
              {mediaFiles.map((file, index) => (
                <MediaPost
                  key={index}
                  file={file}
                  title={titles[index]}
                  description={descriptions[index]}
                  onDelete={() => handleDelete(index)}
                  onTitleChange={(value) => setTitles((prevTitles) => {
                    const newTitles = [...prevTitles];
                    newTitles[index] = value;
                    return newTitles;
                  })}
                  onDescriptionChange={(value) => setDescriptions((prevDescriptions) => {
                    const newDescriptions = [...prevDescriptions];
                    newDescriptions[index] = value;
                    return newDescriptions;
                  })}
                />
              ))}
            </Form.Group>
            <Button variant="primary" type="submit" disabled={uploading}>Post</Button>
            {uploading && <p style={{ color: '#1877F2', marginTop: '1rem' }}>Uploading...</p>}
          </Form>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default MediaUploadForm;
