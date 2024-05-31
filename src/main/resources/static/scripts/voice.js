let recordButton1 = document.getElementById('record-btn1');
let recordButton2 = document.getElementById('record-btn2');
let recordButton3 = document.getElementById('record-btn3');
let mediaRecorder;
let audioChunks = [];

var tell1 = document.getElementById('tell1Area');
var tell2 = document.getElementById('tell2Area');
var tell3 = document.getElementById('tell3Area');

recordButton1.addEventListener('click', () => {
    if (!mediaRecorder || mediaRecorder.state === 'inactive') {
        navigator.mediaDevices.getUserMedia({ audio: true })
            .then(stream => {
                mediaRecorder = new MediaRecorder(stream);
                mediaRecorder.start();

                mediaRecorder.ondataavailable = event => {
                    audioChunks.push(event.data);
                };

                mediaRecorder.onstop = () => {
                    const audioBlob = new Blob(audioChunks, { type: 'audio/mp3' });
                    audioChunks = [];
                    saveAudio(audioBlob);
                    sendAudioToAPI(audioBlob, tell1);
                };
            });
    } else if (mediaRecorder.state === 'recording') {
        mediaRecorder.stop();
    }
});

recordButton2.addEventListener('click', () => {
    if (!mediaRecorder || mediaRecorder.state === 'inactive') {
        navigator.mediaDevices.getUserMedia({ audio: true })
            .then(stream => {
                mediaRecorder = new MediaRecorder(stream);
                mediaRecorder.start();

                mediaRecorder.ondataavailable = event => {
                    audioChunks.push(event.data);
                };

                mediaRecorder.onstop = () => {
                    const audioBlob = new Blob(audioChunks, { type: 'audio/mp3' });
                    audioChunks = [];
                    saveAudio(audioBlob);
                    sendAudioToAPI(audioBlob, tell2);
                };
            });
    } else if (mediaRecorder.state === 'recording') {
        mediaRecorder.stop();
    }
});

recordButton3.addEventListener('click', () => {
    if (!mediaRecorder || mediaRecorder.state === 'inactive') {
        navigator.mediaDevices.getUserMedia({ audio: true })
            .then(stream => {
                mediaRecorder = new MediaRecorder(stream);
                mediaRecorder.start();

                mediaRecorder.ondataavailable = event => {
                    audioChunks.push(event.data);
                };

                mediaRecorder.onstop = () => {
                    const audioBlob = new Blob(audioChunks, { type: 'audio/mp3' });
                    audioChunks = [];
                    saveAudio(audioBlob);
                    sendAudioToAPI(audioBlob, tell3);
                };
            });
    } else if (mediaRecorder.state === 'recording') {
        mediaRecorder.stop();
    }
});

function saveAudio(audioBlob) {
    const url = URL.createObjectURL(audioBlob);
    const a = document.createElement('a');
    a.style.display = 'none';
    a.href = url;
    a.download = 'recorded-audio.webm';
    document.body.appendChild(a);
    a.click();
    window.URL.revokeObjectURL(url);
}


function sendAudioToAPI(audioBlob, tell) {
    const formData = new FormData();
    formData.append('file', audioBlob, 'audio.mp3');

    var data = {
        voice: 'recorded-audio.webm'
    };

    console.log(JSON.stringify(data))

    fetch('http://127.0.0.1:8080/voiceToText/send', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        response.json().then((value) => {
                    tell.value = value.answer;
                  })
        })
    .then(data => {
        console.log('Success:', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}