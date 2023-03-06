import React from "react";
import Evm from "./Components/Evm";
import Demo from "./Components/Demo";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddCandidate from "./Components/AddCandidate";
import Auth from "./Components/Auth";
function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" element={<Auth />} />
          <Route path="/demo" element={<Demo />} />
          <Route path="/addCandidate" element={<AddCandidate />} />
          <Route path="/evm" element={<Evm/>}/>
        </Routes>
      </Router>
      {/* <Evm /> */}
      {/* <AddCandidate/> */}
      {/* <Router>
        <Routes>
          <Route path="/" element={<Evm />} />
          <Route path="/demo" element={<Demo />} />
        </Routes>
      </Router> */}
    </div>
  );
}

export default App;
