import React, { useEffect, useState } from "react";
import axios from "axios";
import base_url from "../api/bootapi";

const Demo = () => {
  useEffect(() => {
    document.title = "Candidate List";
  }, []);

  const getAllCandidateFromServer = () => {
    axios.get(`${base_url}/candidate/getAllParty`).then(
      (response) => {
        console.log("succes");
        setCandidate(response.data);
      },
      (error) => {}
    );
  };

  // calling function
  useEffect(() => {
    getAllCandidateFromServer();
  }, []);

  const [candidate, setCandidate] = useState([]);

  return (
    <>
      <div>
        <h1>All candidate</h1>
        {candidate.length > 0
          ? candidate.map((item) => item.partyName)
          : "No course"}
      </div>
      {/* <button onClick={() => navigate(-1)}>Go Back</button> */}
    </>
  );
};
export default Demo;
