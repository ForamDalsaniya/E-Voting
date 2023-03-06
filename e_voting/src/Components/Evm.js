import React, { useEffect, useState } from "react";
import "../Style/Evm.css";

import Container from "@mui/material/Container";
import { Typography } from "@mui/material";
import Table from "@mui/material/Table";
import TableHead from "@mui/material/TableHead";
import TableBody from "@mui/material/TableBody";
import TableRow from "@mui/material/TableRow";
import TableCell from "@mui/material/TableCell";

import Button from "@mui/material/Button";

import { ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import axios from "axios";
import base_url from "../api/bootapi";
import { useLocation } from "react-router-dom";

//One Row for table
function Row(props) {
  const [style, setStyle] = useState("circle");

  // Function : When button click Light is on...
  const clickHandle = (e) => {
    console.log("clicked!!");
    setStyle("afterClick_circle");
    setTimeout(() => {
      setStyle("circle");
    }, 1500);
    window.alert("Thanks for vote");

    let Vote = { id: e.id, partyName: e.partyName, count: 0 };

    axios.put(`${base_url}/vote/voteCount`, Vote).then(
      (response) => {
        console.log(response.data);
      },
      (error) => {
        console.log("Something went wrong");
      }
    );
  };

  return (
    <>
      <ToastContainer />
      <TableRow className={"hover:bg-gray-100"}>
        <TableCell>
          <Typography style={{ fontWeight: 600 }}>{props.id}</Typography>
        </TableCell>
        <TableCell>
          <Typography style={{ fontWeight: 600 }}>{props.candidate}</Typography>
        </TableCell>
        <TableCell>
          <Typography style={{ fontWeight: 600 }}>{props.partyName}</Typography>
        </TableCell>
        <TableCell>
          <img
            src={`data:image/jpeg;base64,${props.logo}`}
            alt={props.logo}
            className={"h-10 w-11"}
          />
        </TableCell>
        <TableCell>
          <div className={style}></div>
        </TableCell>
        {/* <TableCell></TableCell> */}
        <TableCell>
          <Button
            variant={"contained"}
            style={{
              borderRadius: 35,
              backgroundColor: "#00003B",
              width: 110,
              height: 40,
              fontWeight: "bold",
            }}
            onClick={() => clickHandle(props)}
          >
            Vote
          </Button>
        </TableCell>
      </TableRow>
    </>
  );
}

const Evm = (props) => {
  let count = 1;

  const location = useLocation();
  console.log("here!!");
  console.log(location);
  var stat = {
    stateName: location.state.states,
    constituency: location.state.constituency
  };
  console.log("success");
  console.log(stat);
  const getAllCandidate = () => {
    axios
      .get(
        `${base_url}/candidate/getCandidate/${stat.stateName}/${stat.constituency}`
      )
      .then(
        (response) => {
          console.log("Success from");
          console.log(response);
          setCandidate(response.data);
        },
        (error) => {
          console.log("Failed here");
          console.log(error);
        }
      );
  };
  useEffect(() => {
    getAllCandidate();
  }, []);
  const [candidate, setCandidate] = useState([]);
  return (
    <Container>
      {/* Table */}
      <h1>{stat.stateName}</h1>
      <Table className={"my-32 shadow-lg shadow-gray-500/40 border-2"}>
        <TableHead className={"bg-gray-300"}>
          <TableRow>
            <TableCell
              className={"text-lg font-bold"}
              style={{ fontSize: "20px", fontWeight: "bolder" }}
            >
              No.
            </TableCell>
            <TableCell
              className={"text-lg font-bold"}
              style={{ fontSize: "20px", fontWeight: "bolder" }}
            >
              Candidate Name
            </TableCell>
            <TableCell
              className={"text-lg font-bold"}
              style={{ fontSize: "20px", fontWeight: "bolder" }}
            >
              Party
            </TableCell>
            <TableCell
              className={"text-lg font-bold"}
              style={{ fontSize: "20px", fontWeight: "bolder" }}
            >
              Logo
            </TableCell>
            <TableCell className={"text-lg font-bold"}></TableCell>
            <TableCell className={"text-lg font-bold"}></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {candidate.length > 0
            ? candidate.map((item) => (
                <Row
                  key={count}
                  id={count++}
                  candidate={item.name}
                  partyName={item.party.partyName}
                  logo={item.party.partyLogo}
                ></Row>
              ))
            : "No party"}
        </TableBody>
      </Table>
    </Container>
  );
};
export default Evm;
