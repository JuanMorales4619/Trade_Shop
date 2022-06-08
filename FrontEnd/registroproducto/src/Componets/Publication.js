import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import "../Style-sheets/Publication.css";
import { Container } from "react-bootstrap";
import axios from "axios";

const Publication = () => {
  const [Sendform, ChallengeSendForm] = useState(false);
  const initialValues = {
    name: "",
    description: "",
    price: 0,
    amount: 0,
    TypeOfSale: "",
    Photo: "",
  };

  const [activeField, setAtctiveField] = useState(false);

  const activefield = (values) => {
    if (values.TypeOfSale !== "Intercambio") {
      setAtctiveField(true);
    }
  };

  const validateform = (values) => {
    let errors = {};
    if (!values.name) {
      errors.name = "Por favor, inserte el nombre del producto";
    } else if (!/^[a-zA-ZÁ-ÿ0-9\s]{1,40}$/.test(values.name)) {
      errors.name = "El nombre solo puede contener letras, espacios y numeros";
    }

    if (!values.description) {
      errors.description = "Por favor ingrese una descripcion";
    } else if (!/^[a-zA-ZÁ-ÿ0-9\s]{1,40}$/.test(values.description)) {
      errors.description =
        "La descripcion solo puede contener letras, espacios y numeros";
    }

    if (!values.amount) {
      errors.amount = "Inserte la cantidad del producto";
    } else if (!/^[0-9]{1,40}$/.test(values.amount)) {
      errors.amount = "La cantidad solo puede contener numeros";
    }
    if (!values.TypeOfSale) {
      errors.TypeOfSale = "Por favor seleccione un tipo de venta";
    } else if (values.TypeOfSale !== "Intercambio") {
      activefield(values);
    } else {
      setAtctiveField(false);
    }
    if (!values.price) {
      errors.price = "Por favor ingrese el precio";
    } else if (!/^[0-9]{1,40}$/.test(values.price)) {
      errors.price = "el precio solo puede contener numeros";
    }
    if (!values.Photo) {
      errors.Photo = "Por favor ingrese una foto";
    }

    return errors;
  };
  const ApiConnection = async (initialValues) => {
    const formData = new FormData();
    formData.append("files", initialValues);
    await axios
      .post("http://localhost:8080/create", formData)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <Container>
      <div>
        <h1 className="title">Crear Publicacion</h1>
      </div>
      <Formik
        className="FormikStile"
        initialValues={initialValues}
        validate={validateform}
        onSubmit={(values, { resetForm }) => {
          console.log(values);
          resetForm();
          ChallengeSendForm(true);
          setTimeout(() => ChallengeSendForm(false), 5000);
          ApiConnection(values);
        }}
      >
        {({ errors }) => (
          <Form className="form">
            <div className="col-md-3">
              <label htmlFor="name">Nombre</label>
              <Field
                className="form-control"
                type="text"
                id="name"
                name="name"
                placeholder="Ingrese el nombre"
              />
              <ErrorMessage
                name="name"
                component={() => <div className="errors">{errors.name}</div>}
              />
            </div>
            <div className="col-md-3">
              <label>Descripcion</label>
              <Field
                as="textarea"
                placeholder="Ingrese una descripcion"
                className="form-control"
                type="text"
                name="description"
              />
              <ErrorMessage
                name="description"
                component={() => (
                  <div className="errors">{errors.description}</div>
                )}
              />
            </div>

            <div className="col-md-3">
              <label>Cantidad</label>
              <Field
                placeholder="Inserte la cantidad"
                className="form-control"
                type="numeric"
                name="amount"
              />
              <ErrorMessage
                name="amount"
                component={() => <div className="errors">{errors.amount}</div>}
              />
            </div>
            <div className="Type-of-sale">
              <p> Tipo de venta </p>
              <Field name="TypeOfSale" as="select">
                <option value=""></option>
                <option value="Venta">Venta</option>
                <option value="Intercambio">Intercambio</option>
                <option value="Venta o intercambio">Venta o intercambio</option>
              </Field>
              <ErrorMessage
                name="TypeOfSale"
                component={() => (
                  <div className="errors">{errors.TypeOfSale}</div>
                )}
              />
            </div>
            <div className="col-md-3">
              <label>Precio</label>
              <Field
                placeholder="Ingrese el precio"
                className="form-control"
                type="numeric"
                name="price"
                disabled={!activeField}
              />
              <ErrorMessage
                name="price"
                component={() => <div className="errors">{errors.price}</div>}
              />
            </div>
            <div>
              <Field
                name="Photo"
                type="file"
                placeholder="seleccione una imagen"
                multiple={true}
              />
              <ErrorMessage
                name="Photo"
                component={() => <div className="errors">{errors.Photo}</div>}
              />
            </div>

            <button type="submit">Publicar</button>

            {Sendform && (
              <p className="nice"> Publicacion creada exitosamente</p>
            )}
          </Form>
        )}
      </Formik>
    </Container>
  );
};
export default Publication;