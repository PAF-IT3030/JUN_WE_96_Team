import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import MediaUploadForm from './components/MediaUploadForm/MediaUploadForm';
function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/mediaupload" element={<MediaUploadForm />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
