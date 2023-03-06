import {
  Avatar,
  Button,
  FormControl,
  MenuItem,
  OutlinedInput,
  Select,
  InputLabel,
  Grid,
  Paper,
  TextField,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import "../Style/AddCandidate.css";
// import LocalizationProvider from
import AddCircleOutlineOutlinedIcon from "@mui/icons-material/AddCircleOutlineOutlined";
import axios from "axios";
import base_url from "../api/bootapi";

export default function AddCandidate() {
  const [candidate, add_candidate] = useState([]);
  const handleForm = (e) => {
    console.log("here");
    console.log(candidate);
    // candidate.party.id = 1;
    let Candidate = {
      adharId: candidate.adharId,
      name: candidate.name,
      city: candidate.city,
      mobileNo: candidate.mobileNo,
      dob: candidate.dob,
      constituency: candidate.constituency,
      state: candidate.state,
      party: { id: candidate.party },
    };
    saveCandidate(Candidate);
    e.preventDefault();
  };

  const getAllParty = () => {
    axios.get(`${base_url}/party/getAllParty`).then(
      (response) => {
        setParty(response.data);
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  };
  useEffect(() => {
    getAllParty();
  }, []);
  const [party, setParty] = useState([]);
  // function for post data to server
  const saveCandidate = (data) => {
    axios.post(`${base_url}/candidate/addCandidate`, data).then(
      (response) => {
        console.log("Success");
        console.log(response);
      },
      (error) => {
        console.log("error");
        console.log(error);
      }
    );
  };

  return (
    <Grid>
      <Paper elevation={20} className="paperStyle">
        <Grid align="center">
          <Avatar>
            <AddCircleOutlineOutlinedIcon />
          </Avatar>
          <h2 className="headerStyle">Add Candidate</h2>
          <Typography>Please fill your information correctly!</Typography>
        </Grid>
        <form onSubmit={handleForm}>
          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            id="adhar"
            onChange={(e) => {
              add_candidate({ ...candidate, adharId: e.target.value });
            }}
            label="Adhar Id"
            placeholder="Enter your adhar card no"
          />
          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            label="Name"
            placeholder="Enter your name"
            id="candidate_name"
            onChange={(e) => {
              add_candidate({ ...candidate, name: e.target.value });
            }}
          />
          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            id="_city"
            onChange={(e) => {
              add_candidate({ ...candidate, city: e.target.value });
            }}
            label="City"
            placeholder="Enter your City"
          />
          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            id="_mobileNo"
            onChange={(e) => {
              add_candidate({ ...candidate, mobileNo: e.target.value });
            }}
            label="Mobile No"
            placeholder="Enter your mobile no"
          />
          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            label="Date of Birth"
            id="_dob"
            onChange={(e) => {
              add_candidate({ ...candidate, dob: e.target.value });
            }}
            InputLabelProps={{ shrink: true }}
            type="date"
          />

          <TextField
            style={{ marginTop: 10 }}
            fullWidth
            id="_constituency"
            onChange={(e) => {
              add_candidate({ ...candidate, constituency: e.target.value });
            }}
            label="Constituency"
            placeholder="Enter your constituency"
          />

          <FormControl sx={{ marginTop: 1.5, width: 310 }}>
            <InputLabel id="demo-multiple-name-label">Party</InputLabel>

            <Select
              input={<OutlinedInput label="Party" />}
              value={party.id}
              onChange={(e) => {
                add_candidate({ ...candidate, party: e.target.value });
              }}
              inputProps={{
                name: "partyName",
                id: "id",
              }}
            >
              <MenuItem value="">
                <em>None</em>
              </MenuItem>
              {party.map((item) => {
                return <MenuItem value={item.id}>{item.partyName}</MenuItem>;
              })}
            </Select>
          </FormControl>

          <Button style={{ marginTop: 12 }} type="submit" variant="contained">
            Add
          </Button>
        </form>
      </Paper>
    </Grid>
  );
}
