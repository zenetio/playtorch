import * as React from 'react';
import {Text, StyleSheet, View} from 'react-native';
import {Camera} from 'react-native-pytorch-core';

export default function ImageClassificationDemo() {
  return (
    <View style={styles.container}>
      <Text style={styles.label}>Image Classification</Text>
      <Camera style={styles.camera} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    backgroundColor: '#ffffff',
    flexGrow: 1,
    padding: 20,
  },
  label: {
    marginBottom: 10,
  },
  camera: {
    flexGrow: 1,
    width: '100%',
  },
});
