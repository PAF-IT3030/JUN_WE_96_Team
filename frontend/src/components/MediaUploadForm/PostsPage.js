import React, { useState } from 'react';
import MediaPost from './MediaPost';

const PostsPage = () => {
  const [posts, setPosts] = useState([]);

  // Function to handle adding a new post
  const handleAddPost = (post) => {
    setPosts([...posts, post]);
  };

  // Function to handle deleting a post
  const handleDeletePost = (index) => {
    const updatedPosts = [...posts];
    updatedPosts.splice(index, 1);
    setPosts(updatedPosts);
  };

  // Function to handle liking a post
  const handleLikePost = (index) => {
    const updatedPosts = [...posts];
    updatedPosts[index].liked = !updatedPosts[index].liked;
    setPosts(updatedPosts);
  };

  // Function to handle adding a comment to a post
  const handleAddComment = (index, comment) => {
    const updatedPosts = [...posts];
    updatedPosts[index].comments.push(comment);
    setPosts(updatedPosts);
  };

  return (
    <div>
      <h1>Posts</h1>
      {posts.map((post, index) => (
        <MediaPost
          key={index}
          post={post}
          onDelete={() => handleDeletePost(index)}
          onLike={() => handleLikePost(index)}
          onComment={(comment) => handleAddComment(index, comment)}
        />
      ))}
    </div>
  );
};

export default PostsPage;
