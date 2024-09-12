# Catherine Gichuhi's assessment

The goal of this assessment is to create a test plan to validate that our newly built Employee API endpoints
are working correctly.

## Employee API Overview

First, let's give a quick overview of the Employee API:

The API is hosted at the URL: https://assessments.codescreen.com/api/employees. The API contains for 5 endpoints:

- `POST` `/`. Creates a new employee. 
- `GET` `/`. Retrieves a list of employees that the authenticated user created.
- `GET` `/{id}`. Retrieves the details for the employee with the given id.
- `PATCH` `/{id}`. Updates the employee with the given id.
- `DELETE` `/{id}`. Deletes the employee with the given id.

An `Employee` object contains the following fields:

- `id`. The unique id of the employee.
- `email`. The email address of the employee.
- `name`. The name of the employee.
- `title`. The job title of the employee.

No two employees can have the same email address. The `email` cannot be modified for an employee. The `name` and `title` fields can be modified.

### Status Code Responses

Successful requests will return a response with one of the following success codes:

<table>
<thead>
<tr>
<td style="white-space: nowrap;">Status Code</td><td>Description</td></tr>
</thead><tbody>
<tr>
<td>200</td><td>A request to return, update or delete an employee has been successful.</td></tr>
<tr>
<td>201</td><td>A request to create an employee has been successful.</td></tr>
</tbody></table>

Unsuccessful requests will return a response with one of the following error codes:

<table>
<thead>
<tr>
<td style="white-space: nowrap;">Status Code</td><td>Description</td></tr>
</thead><tbody>
<tr>
<td>400</td><td>Occurs when an employee is created with missing required fields.</td></tr>
<tr>
<td>401</td><td>Occurs when a request is made using an invalid API key or when no API key is included in the request.</td></tr>
<tr>
<td>403</td><td>Occurs when a request is made to create an employee with an existing email address or when an employee's email address is attempted to be updated.</td></tr>
<tr>
<td>404</td><td>Occurs when a requested resource could not be found, i.e. a request to an unknown API endpoint or getting/updating/deleting an employee that does not exist.</td></tr>
</tbody></table>

In order to authenticate with the API, you need to pass your API Key in the `X-API-KEY` header of each request. Your API
Key can be found in the [EmployeeAPITest](src/test/java/com/codescreen/EmployeeAPITest.java) class.

Here is an example of how to send a request to retrieve an employee from `cURL`, where the API Key is `xxx` and the
Employee ID is `1234`:

    curl -H "X-API-KEY: xxx" \
    https://assessments.codescreen.com/api/employees/1234

**Note** the API Key `xxx` is just used here as an example and is not valid. Please use the API key listed in 
[EmployeeAPITest](src/test/java/com/codescreen/EmployeeAPITest.java) to authenticate with the API.

## Your Task

Your task is to write test cases in the [EmployeeAPITest](src/test/java/com/codescreen/EmployeeAPITest.java) class using
the [Rest Assured](https://rest-assured.io/) library that cover all scenarios that the API needs to handle.

We provide an example test case in the `EmployeeAPITest` class to show you how to use the `Rest Assured` library.

## Requirements

Your solution be use/be compatible with `Java version 1.17`.

The [pom.xml](/pom.xml) file must not be modified.

## Tests
Run `mvn clean test` to run the unit tests in the `EmployeeAPITest` class.

##

Happy coding!
## License

At CodeScreen, we strongly value the integrity and privacy of our assessments. As a result, this repository is under exclusive copyright, which means you **do not** have permission to share your solution to this test publicly (i.e., inside a public GitHub/GitLab repo, on Reddit, etc.). <br>

## Submitting your solution

Please push your changes to the `main branch` of this repository. You can push one or more commits. <br>

Once you are finished with the task, please click the `Submit Solution` link on <a href="https://app.codescreen.com/candidate/e5854134-3a6f-44f8-ae96-434748e943f4" target="_blank">this screen</a>.