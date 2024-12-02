async function get(english) {
  try {
    const resp = await fetch("https://kanjialive-api.p.rapidapi.com/api/public/search/advanced/?" + english, {
      method: "GET",
      headers: {
        'x-rapidapi-host': 'kanjialive-api.p.rapidapi.com',
        'x-rapidapi-key': '9155db1618msh0e48996e92ed20ep10c960jsn6d399cd4d78c',
      }
    });
    return resp;
  } catch (error) {
    console.log(error);
    return null;
  }
}
//

async function getKanji(kanji) {
  try {
    const resp = await fetch("https://kanjialive-api.p.rapidapi.com/api/public/kanji/" + kanji, {
      method: "GET",
      headers: {
        'x-rapidapi-host': 'kanjialive-api.p.rapidapi.com',
        'x-rapidapi-key': '9155db1618msh0e48996e92ed20ep10c960jsn6d399cd4d78c',
      }
    });
    return resp;
  } catch (error) {
    console.log(error);
    return null;
  }
}
async function authSingup(path, body) {
  try {
    const resp = await fetch("http://localhost:8005/auth" + path, {
      method: "POST",
      credentials: 'include',
      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(body),
    });


    return resp;
  } catch (error) {
    console.log(error)

  }
}


async function loginAuth(path, body) {
  try {
    const resp = await fetch("http://localhost:8005/auth" + path, {
      method: "POST",
      credentials: 'include',
      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(body),
    });


    return resp;
  } catch (error) {
    console.log(error)

  }
}

async function getAboutme(path) {

  try {
    const token = localStorage.getItem("token")
    console.log(token, "for me")
    const resp = await fetch("http://localhost:8005/users" + path, {
      method: "GET",
      credentials: 'include',
      headers: {
        "Content-Type": "application/json",
        ...(token && { Authorization: `Bearer ${token}` }),
      }
    });
    console.log(resp)

    return resp;
  } catch (error) {
    console.log(error)

  }
}

async function save(path, body) {

  try {
    const resp = await fetch("http://localhost:8005/" + path, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });

    console.log(resp)


    return resp;
  } catch (error) {
    console.log(error)

  }
}


export default {
  get,
  getKanji,
  authSingup,
  loginAuth,
  getAboutme,
  save

}